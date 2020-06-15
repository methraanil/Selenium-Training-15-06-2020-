package testNG;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
 
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
 
public class AnnotationTransformer implements IAnnotationTransformer {
  
 //Overriding the transform method to set the RetryAnalyzer
 @SuppressWarnings({ "rawtypes", "deprecation" })
public void transform(ITestAnnotation testAnnotation,Class testClass, 
 Constructor testConstructor, Method testMethod) {
 IRetryAnalyzer retry = testAnnotation.getRetryAnalyzer();
 if (retry == null)
	 testAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
	 }
	}