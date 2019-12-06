package mustafa.mustafa;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa. org.testng.Assert;
import asd.RequestSpecification;
import groovyjarjarasm.asm.commons.Method;
public class test {

public class test_case {
	

		RestAssured.baseURI="Http://www.n11.com";
		private static RestAssured htttpRequest;
		RequestSpecification httpRequest=(RequestSpecification) RestAssured.given();
		private Object action;
		public static Response response=htttpRequest.request(Method.get,"");

	public void anasayfa() {
		
		try {
			
			response.get("http://www.n11.com/");
			String result=response.getContentType();
			String result1="n11.com";
			Assert.assertEquals(result, result1);					
			System.out.println("n11desin "+response.getContentType()); 
			
		}
		catch (AssertionError a){
			System.out.println("Sayfa açılmadı");
			
		
		}
		}
	public void login() throws InterruptedException {
		response.findElement(By.className("btSignIn")).click();
		Thread.sleep(5000);
		response.findElement(By.id("email")).sendKeys("adminn@gmail.com");
		response.findElement(By.id("password")).sendKeys("12345");
		response.findElement(By.id("loginButton")).click();
		Thread.sleep(5000);
		
		try {
			
			System.out.println("Başarıyla '"+response.getContentType()+"' hesabına giriş yapıldı");
			
		} catch (NoSuchElementException e ) {
			System.out.println("giriş yapılamadı");
		
		}
	}
	public void search() throws InterruptedException {
		try {
		response.findElement(By.id("searchData")).sendKeys("bilgisayar");
		response.findElement(By.className("searchBtn")).click();
		Thread.sleep(2000);
		String sonuc = response.getContentType();
		String sonuc1 ="bilgisayar - n11.com";
		Assert.assertEquals(sonuc1, sonuc);
		System.out.println("Aratılan kelime "+response.getContentType().split("-")[0]);
		Thread.sleep(2000);
		response.findElement(By.cssSelector("#contentListing > div > div > div.productArea > div.pagination > a:nth-child(2)")).click();;
		
		}
		catch(AssertionError a) {
			System.out.println("Arama yapýlamadý");
		}
		
	}
	public  void sepet() throws InterruptedException {
		List<WebElement> a =response.findElement(By.cssSelector("#contentListing > div > div > div.productArea > section.group.listingGroup.resultListGroup")).findElements(By.className("followBtn"));
		a.get(2).click();

		
	}
	public  void sepet2() throws InterruptedException {
		
       WebElement element = response.findElement(By.linkText("Hesabım"));
        action.moveToElement(element).build().perform();
        response.findElement(By.linkText("istek Listem / Favorilerim")).click();
        Thread.sleep(5000);
		try {
			String sonuc=response.getContentType();
			String sonuc1="istek Listelerim - n11.com";
			Assert.assertEquals(sonuc1, sonuc);
			System.out.println("sepet açıldı");
		}
		catch (AssertionError a) {
			System.out.println("sepet açılamadı");
		}
	}
	public void sepetdelete() throws InterruptedException {
		response.findElement(By.className("listItemTitle")).click();
		Thread.sleep(3000);
		response.findElement(By.className("deleteProFromsepet")).click();
		System.out.println("Silinen Ürün: "+response.findElement(By.className("productName")).getText());
		Thread.sleep(1000);
		response.findElement(By.cssSelector("body > div.lightBox > div > div > span")).click();
		
		try {
			response.findElement(By.className("column wishListColumn "));
			}
			catch (NoSuchElementException e) {
				System.out.println("Ürün Baþarýyla Silindi");
				cikis();
				
			}
	}
	public  void cikis() throws InterruptedException {
			response.get("https://www.n11.com/");
	        action.moveToElement(response.findElement(By.linkText("Hesabým"))).moveToElement(response.findElement(By.className("logoutBtn"))).click().build().perform();
	        Thread.sleep(2000);
	        
	}
	
	public  void main(String[] args) throws InterruptedException, FileNotFoundException {
		anasayfa();
		login();
		search();
		sepet();
		sepet2();
		sepetdelete();
		
	}

}
