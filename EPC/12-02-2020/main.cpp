#include <stdio.h>
#include <stdlib.h>
#include <iostream>

#include "calculation.h"
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

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
	double radius = 2.3;
	double height = 2.0;
	double volume = getVolumeOfCylinder(radius, height);
	printf("Volume of a cylinder : %lf", volume);
	return 0;
}


