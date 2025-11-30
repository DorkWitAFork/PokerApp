# Git Workflow

Below are the git commands to enter from the terminal as part of your project workflow.



## 1. Create a New Branch

Start from the latest `main`:

1. git checkout main
2. git pull origin main
3. git checkout -b <branch-name>

## 2. Create a New Branch
git add "the files you worked on"

git commit -m "Describe your change here"


## 3. Sync With Main Before Pushing

git fetch

git rebase origin/main

### If there is a conflict: 

git add "conflicted-files"

git rebase --continue

## 4. Push Your Branch
git push -u origin "branch-name"


## 5. Submit a Pull Request
1. Go to GitHub
2. Open a Pull request from your branch into main
3. Request review
4. Apply changes if needed
5. Merge when Ready

## 6. Update Local Main After the Merge
git checkout main

git pull origin main

## 7. Delete the Local Feature Branch
git branch -d "branch-name"
