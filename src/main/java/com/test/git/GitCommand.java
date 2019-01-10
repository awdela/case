package com.test.git;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;

public interface GitCommand {
	
	public void add(String fileName) throws GitAPIException;
	
	public RevCommit commit(String fileName) throws GitAPIException;
	
	public void delete(String fileName) throws GitAPIException;
	
	public void log() throws GitAPIException;
	
	public void push() throws GitAPIException;
	
	public void pull() throws GitAPIException;

}
