#include <math.h>
float getFarenheitFromCelcius(float celsius) {
	return (9.0/5.0)*celsius + 32.0;
}
double calculateRectanglePerimeter(double width, double height) {
	return 2*(width + height);
}

double getVolumeOfCylinder(double radius, double height){
	//return M_PI * radius * radius * height;
	return M_PI * pow(radius, 2) * height;
}
