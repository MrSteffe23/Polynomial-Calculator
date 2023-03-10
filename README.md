# Polynomial-Calculator

This was a project built in **Java** using IntelliJ IDEA.   
It is a **Polynomial Calculator** which can execute operations on polynomials with a single variable and integer coefficients and powers. I created an interface where the user can insert 2 polynomials in 2 different text boxes, and then have the possibility to press 6 different buttons:    
- Add
- Subtract
- Multiply
- Divide
- Derivative
- Integrate   

![p2](https://user-images.githubusercontent.com/101935675/224381154-26739184-deb7-4359-aa47-f53a647e2b3f.png)

Depending on which button the user pressed, the result will appear in the interface in an area text. If he executes the divide operation, also the remainder will appear on the display.   

![p1](https://user-images.githubusercontent.com/101935675/224381137-3964a30b-6429-4000-bf6d-7bf62a69c111.png)

I used a ***MVC structure***, ***regexes*** for the *decomposition of polynomials in monomials*, and then for the *decomposition of monomials in coefficient and power*.   
I implemented the GUI using **Java Swing**.   
The user have to insert a valid polynomial: integer coefficients and integer powers for the variable. Of course, the divider can't be zero for the divide operation (a message will appear to warn the user in this case).    

![p3](https://user-images.githubusercontent.com/101935675/224387452-26e7f6a0-926b-4662-8e85-bf84d9b60dfb.png)


The challenge with this project was learning the regex syntax, which turned out to be pretty easy in the end.
I am looking forward to develop this project in the future with enhancements like: multiple variables for polynomials, more operations, real coefficients and more.
