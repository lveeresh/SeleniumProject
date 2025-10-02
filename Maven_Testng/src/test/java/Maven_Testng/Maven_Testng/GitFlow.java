package Maven_Testng.Maven_Testng;

public class GitFlow {

	public static void main(String[] args) {
		
		
/*		
 * 
 
		git stash
		Temporarily saves your uncommitted changes so you can safely update your local branch without losing work.
		
		git pull origin staging(or main, depending on your base branch)
		Pulls the latest changes from the remote branch to ensure your local branch is up to date before pushing your changes.
		
		git stash pop
		Restores the changes you stashed earlier, bringing your work back into the working directory.
		
		Stage your changes
		Use git add . or git add <filename> to move your modified files to the staging area.
		
		Commit your changes
		Use git commit -m "Your meaningful commit message" to save your changes locally.
		
		Push your changes to your feature branch
		Use git push origin <your-branch-name> to push your committed changes to the remote repository.
		
		Raise a Pull Request (PR)
		Create a PR from your feature branch to the target branch (e.g., staging or main) and request a review from your lead or team.
		
		Merge after approval
		Once the PR is reviewed and approved, merge it into the target branch (usually main or staging).
 
 
 

 		1. git stash   --> this command will save u work before taking latest code/pull -->after this get latest pull

		2. git pull origin staging/main   --> here u trying to make the code upto the date in local also, before pushing ur's
		
		3. git stash pop/apply    -->this command retrieve the code/logic which u r saved earlier in the 1st point
		
		4. then add your changes into staging area
		
		5. then commit the changes to u r local branch
		
		6. then push the code to the local branch
		
		7. Raise the PR and get it approved from u r lead
		
		8. then merge the code to main/master branch after u r approvals done
		
		
		9. git conflict  resolution
			
			Git conflict resolution happens when multiple changes are made to the same part of a file in different branches,
			 and Git can't automatically merge them. Here's how to resolve conflicts step-by-step:
			 
			> when you run --> git merge <branch-name>

			Git may respond with:

			CONFLICT (content): Merge conflict in <filename>
			Automatic merge failed; fix conflicts and then commit the result.
			
			> Steps to Resolve Git Conflicts:
			
			1. Open the conflicted file
			You'll see conflict markers like:
			
			<<<<<<< HEAD
			Your changes
			=======
			Incoming changes
			>>>>>>> branch-name
			
			2. Manually edit the file
			Decide which changes to keep:
			
			Keep your changes
			Keep incoming changes
			Combine both
			
			3. Remove conflict markers
			Delete <<<<<<<, =======, and >>>>>>> after resolving.
			
			4. Mark the conflict as resolved
--------------------------------------------------------------------

git reset:

To get commit id/commit hash---> perform git log

git reset <file>            		Unstage a file before committing.
git reset --soft <commit>			Undo commits but keep changes staged.
git reset --mixed <commit>			Undo commits and unstage changes.
git reset --hard <commit>			Undo commits and discard changes completely.
		
*/
	}

}
