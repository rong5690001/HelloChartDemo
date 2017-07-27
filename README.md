
## gradle 
Add it in your root build.gradle at the end of repositories:
```
allprojects {
    	repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
    ```
Add the dependency:
```
dependencies {
		compile 'com.github.rong5690001:HelloChartDemo:1.1'
}
```
  
## maven 
```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```
Add the dependency:
```
<dependency>
  	<groupId>com.github.rong5690001</groupId>
	<artifactId>HelloChartDemo</artifactId>
	<version>1.1</version>
</dependency>
```

