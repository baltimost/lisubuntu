//: PackageDemo.java

//package g3ds.joop.ch5;

public class PackageDemo{
	public static void main(String[] args) {
		Package pkg;

		pkg = Package.getPackage("java.lang");

		System.out.println(
			pkg.getName() + "; " +
			pkg.getImplementationTitle() + "; " +
            pkg.getImplementationVendor() + "; " +
            pkg.getImplementationVersion()
      	);
	}
}