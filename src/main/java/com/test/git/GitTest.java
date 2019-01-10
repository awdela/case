package com.test.git;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class GitTest {

	public static void commitFiles (String filePath) throws IOException, GitAPIException{

		//creat repository
		Repository newRepo = FileRepositoryBuilder.create(new File(filePath));
//		File repo = new FileRepositoryBuilder().
		CredentialsProvider provider = new UsernamePasswordCredentialsProvider("", "");
		Git git = Git.open(new File(""));
		File myFile = new File(filePath);
		AddCommand command = git.add();
		command.addFilepattern("pets").call();

	}

	public static void main(String[] args) {
		long s = 5;
		System.out.println();
	}

}
