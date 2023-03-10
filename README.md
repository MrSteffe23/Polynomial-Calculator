# Polynomial-Calculator

This was a project built in Java using IntelliJ IDEA. It is a polynomial calculator which can execute operations on polynomials with a single variable and integer coefficients and powers. I created an interface where the user can insert 2 polynomials in 2 different text boxes, and then have the possibility to press 6 different buttons: Add, Subtract, Multiply, Divide, Derivative, Integrate. Depending on which button the user pressed, the result will appear in the interface in an area text. If he executes the divide operation, also the remainder will appear on the display. 
I used a MVC structure. I used regexes for the decomposition of polynomials in monomials, and then for the decomposition of monomials in coefficient and power.
The user have to insert a valid polynomial: integer coefficients and integer powers for the variable. Of course, the divider can't be zero for the divide operation (a message will appear to warn the user in this case). 
The challenge with this project was learning the regex syntax, which turned out to be pretty easy in the end.
I am looking forward to develop this project in the future with enhancements like: multiple variables for polynomials, more operations, real coefficients and more.
