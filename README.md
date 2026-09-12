# Step_semester_3

Repository for Step Semester 3 Java Programming Sessions, Problem Sets, and Lab Exercises.

## Project Structure

```text
Step_semester_3/
├── README.md
├── src/
│   └── string/
│       ├── class_problems/
│       └── assignment_problems/
├── lib/
└── bin/
```

---

## Session 1

**Date:** 2026-09-03

**Topic:** Day 1 Live-Coding Session — 5 Problems (Strings & Logic)

**Branch:** `feature/session_1`

### Problems Solved:
1. **Rock-Paper-Scissors Game** (`RockPaperScissorsGame.java`)
   - Simulates 5 rounds of Rock-Paper-Scissors against random computer moves.
   - Outputs a round-by-round summary table with win percentage calculations.
2. **Palindrome Checker (3 Approaches)** (`PalindromeChecker.java`)
   - Verifies palindromes using 3 independent techniques: Iterative, Recursive, and Character Array Reversal.
   - Validates that all three methods produce consistent results.
3. **BMI Calculator for a Team** (`BmiCalculator.java`)
   - Computes Body Mass Index (BMI = weight / height²) for a team of employees.
   - Categorizes status into Underweight, Normal, Overweight, and Obese with formatted tabular reports.
4. **First Non-Repeating Character** (`FirstNonRepeatingCharacter.java`)
   - Computes character frequencies and scans left-to-right to find the first unique character.
5. **Reverse Customer Name** (`ReverseCustomerName.java`)
   - Reverses customer names without mutating the original input data for verification testing.

**Status:**
- Merged into develop
- Merged into main

**Notes:**
- Plain Java implementation without external build tools (no Maven/Gradle).
- Fully compiled and verified with Java 23.

---

## Week 1 Assignment

**Date:** 2026-09-12

**Topic:** Week 1 Assignment — 5 Problems (Strings, Arrays & Logic)

**Branch:** `feature/assignment_1`

### Problems Solved:
1. **The Exam Hall Seat Duplication Checker** (`ExamSeatDuplicationChecker.java`)
   - Scans an array of seat numbers using nested loops to detect and flag duplicates without using Collections.
   - Outputs identified duplicate seat numbers or confirms no duplicates exist.
2. **The Typing Speed Test Accuracy Checker** (`TypingSpeedAccuracyChecker.java`)
   - Traverses reference and typed passages character-by-character using `charAt()`.
   - Computes match counts, accuracy percentage, and pinpoints the 1-based position and characters of the first mismatch.
3. **The Traffic Signal Streak Analyzer** (`TrafficSignalStreakAnalyzer.java`)
   - Analyzes traffic signal color logs in a single traversal to track consecutive identical signals.
   - Reports the longest continuous streak and its repeating character.
4. **The Warehouse Inventory Balancer** (`WarehouseInventoryBalancer.java`)
   - Compares inventory counts between Section A and Section B to confirm total balance.
   - Identifies the highest-quantity item across the entire warehouse with section name and 1-based item index.
5. **The Movie Review Word Length Profiler** (`MovieReviewWordLengthProfiler.java`)
   - Splits review text into individual words using `split()`.
   - Classifies and counts word lengths into Short (1–4), Medium (5–8), and Long (9+) categories for moderation analysis.

**Status:**
- Merged into develop
- Merged into main

**Notes:**
- Implementation strictly uses primitive arrays, loops, and String operations without Collections.
- Fully compiled and verified with Java 23.

