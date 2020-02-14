#include <stdio.h>
#include <stdlib.h>
#include "calculation.h"
#include "rectangle.h"
#define PII 3.14
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
enum Direction {
	NORTH,
	SOUTH,
	EAST,
	WEST
};
enum Quality {
	GOOD,
	BAD,
	EXCELLENT
};
void sayHello(char name[100]) {
	printf("\nHello mr %s", name);
	//return "kk";
}
int main(int argc, char *argv[]) {
	float celsius;
	/*
	printf("Enter celsius : "); scanf("%f", &celsius);
	farenheit = (9.0/5.0)*celsius + 32.0;
	printf("farenheit = %0.2f", farenheit);
	*/
	//printf("Enter celsius : "); scanf("%f", &celsius);
	//cout<<"Enter celsius : "<<endl;cin>>celsius;
	//are there any way to input data ?
	//printf("farenheit = %0.2f", getFarenheitFromCelcius(celsius));
	//cout<<"farenheit = "<<getFarenheitFromCelcius(celsius)<<endl; //endl = "\n" = end line
	/*
	double width, height;
	printf("Enter width : "); scanf("%lf", &width);
	printf("Enter height : "); scanf("%lf", &height);
	double perimeter = calculateRectanglePerimeter(width, height);
	printf("\nPerimeter = %3.2lf", perimeter);
	*/
	/*
	double radius = 2.3;
	double height = 2.0;
	double volume = getVolumeOfCylinder(radius, height);
	printf("Volume of a cylinder : %lf", volume);
	*/
	/*
	float width, height;
	printf("Enter rectangle's width : "); scanf("%f", &width);
	printf("\nEnter rectangle's height : "); scanf("%f", &height);
	printf("Rectangle's perimeter = %3.2f", getPerimeter(width, height));
	printf("Rectangle's area = %3.2f", getArea(width, height));
	*/
	const PI = 3.1415; //const = constant = read only
	//PI = 5.0;
	//char x = 'y';
	//input a char from keyboard
	/*
	char yesOrNo;
	printf("Do you agree with this ?");
	//yesOrNo = getchar();
	scanf("%c", &yesOrNo);
	printf("\n Your answer is : %c", yesOrNo);
	*/
	//enumeration make your code more familiar/natural language 
	printf("Direction SOUTH is : %d", SOUTH);
	sayHello("Hoang");
	int a = 5;
	int b = 2;
	printf("\na/b = %d", 5/2);
	printf("\na/b = %f", (float)5/(float)2);
	//the remains of a / b  ? 
	printf("\nremains of a / b = %d", a % b);
	return 0;
}
