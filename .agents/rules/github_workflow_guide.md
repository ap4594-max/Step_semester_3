# STEP — GitHub Repository Structure Guide (Semester 3)
Version Control & Daily Workflow Standard for `Step_semester_3`

## Branching Structure
1. **`main` Branch**:
   - Documentation & daily progress log only.
   - Contains `README.md` formatted as a running daily journal.
   - Format for each entry (newest on top):
     ```markdown
     ## Date: DD-MM-YYYY

     **Today's Work:**
     - Summary of what was completed in this session

     **Next Session Plan:**
     - What you plan to work on next

     **Issues Faced:**
     - Any blockers, errors, or doubts encountered (or 'None')

     ---
     ```

2. **`develop` Branch**:
   - Base project structure / development baseline.

3. **Feature Branches**:
   - Created from `develop` for each session / assignment / program (e.g. `feature/session_1`, `feature/assignment_1`, or per-program feature branches).
   - Solved code is placed in topic packages and sub-packages.
   - Pushed to GitHub remote (`origin`).
   - Merged into `develop` upon completion.

## Package Structure
```text
src/
  <topic>/
    class_problems/
      <ProblemName>.java
    assignment_problems/
      <AssignmentName>.java
```

## Git Remote & Workflow Rules
- Remote: `origin https://github.com/ap4594-max/Step_semester_3.git`
- Push feature branches to remote repository.
- Merge completed feature branches into `develop`.
- Maintain `main` documentation log.
