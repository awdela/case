package com.test.git;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.AbortedByHookException;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class RepositorytBuilder{

	private static Repository repo;
	private static Ref master;
	private static ObjectId obj;
	private static Git git;
	private static final String gitPath = "/home/git";
	
	public RepositorytBuilder(String file) {
		try {
			git = Git.init().setDirectory(new File(file)).call();
			repo = git.getRepository();
			if (repo != null) {
				System.out.println("repo is not null");
			}
//			repo = new FileRepositoryBuilder().setGitDir(new File(file)).readEnvironment().findGitDir().build();
//			if (repo == null) {
//				repo = FileRepositoryBuilder.create(new File(file));
//				repo.create();
//			}
//			master = repo.getRef("refs/heads/master");
//			System.out.println("master:"+master.getName());
//			if (master != null) {
//				obj = master.getObjectId();
//			}
			//git = Git.cloneRepository().setURI("https://github.com/eclipse/jgit.git").setDirectory(new File(file)).call();
		}
		catch(Exception e) {
			System.out.println("reason: "+e.getMessage());
		}
//		git = new Git(repo);
//		CommitCommand commit = git.commit();
//		commit.setMessage("init commit").call();
	}
	
	//创建分支
	public void createBranch(String branchPath) throws IOException {
		RefUpdate createBranch1 = repo.updateRef(branchPath);
		createBranch1.setNewObjectId(obj);
		createBranch1.update();
	}
	//删除分支
	public void deleteBranch(String branchPath) throws IOException {
		RefUpdate createBranch1 = repo.updateRef(branchPath);
		createBranch1.setForceUpdate(true);
		createBranch1.delete();
	}

	public static RevCommit commit(String fileName) throws GitAPIException{
		add(fileName);
		RevCommit rev = git.commit().setMessage("add: "+fileName).call();
		return rev;
	}
	
	public static void add(String fileName) throws GitAPIException {
		git.add().addFilepattern(fileName).call();
	}

	public void delete(String fileName) throws GitAPIException {
		git.rm().addFilepattern(fileName).call();
	}

	public void log() throws GitAPIException{
		
	}

	public void push() throws GitAPIException{
		
	}

	public void pull() throws GitAPIException{
		
	}
	
	public static void main(String[] args) {
		try {
			RepositorytBuilder builder = new RepositorytBuilder(gitPath);
//			builder.createBranch(gitPath+"/test");
			builder.commit("test.txt");
		} catch (GitAPIException e) {
			System.out.println("git command error");
			e.printStackTrace();
		}
	}
}
