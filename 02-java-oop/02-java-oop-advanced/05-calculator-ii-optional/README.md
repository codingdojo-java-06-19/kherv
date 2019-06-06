# Calculator II

Pushed on 6/6/19 a.m. as a working calculator, but it does not use order of operations, yet, as the platform calls for

 * Needs more work to convert this calculator to an "order of operations" calculator given a list of operands and operators
 * 
 * Seems like the solution is to feed the nums and operators into a string or array...then search the array for the first *  or /  then operator using that operator with the preceding and following num...then replace that triplet of num operator num with the result...then repeat until no  or / left
Then repeat for + and - until the string or array is just one value

Alternate:  instead of replacing contents in the original array, use a second array

Checklist:
1.  Created method that takes in any double and converts to String then pushes onto the array...confirmed working
2.  Modified method that takes in a string (would be the operators) and pushes into array
3.  Confirm we have an array of all the operands and operators
4.  When the equal sign is encountered, we need to start the math work...it will also look like a string, so see about calling third method when "=" is encountered...that worked
5.  Demonstrate looping through array and ability to look back and forward when proper operators are encountered
6.  For loop for handling multiplication with removals
7.  Another for loop for handling addition with removals
8.  print out result
9.  Need more work to handly division and subtraction....just a couple of if statements
10. Needs some code cleanup