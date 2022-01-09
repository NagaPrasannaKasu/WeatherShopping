package selenium.webdriver;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class launch {
    public static WebDriver driver = null;
    
    
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NKS\\Documents\\personal\\CV_CoverLetter\\1Tasks\\SeleniumJava_weathershopper\\weathershopping\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//openwebapp
		driver.navigate().to("https://weathershopper.pythonanywhere.com/");
		driver.manage().window().maximize();
		
		//validate
		String main_title = driver.getTitle();
		if(main_title.equalsIgnoreCase("current temperature"))
		{
			System.out.println("Main Title matched: "+main_title);
		}
		else
		{
			System.out.println("Main Title didn't match! ");
		}
		
		//locate web elements
		String temperature=" ";
		temperature = driver.findElement(By.cssSelector("#temperature")).getText(); 
		System.out.println("Temperature is: "+temperature); 
		Thread.sleep(2000);
		String numberonly = temperature.replaceAll("[^0-9]", "");
		Integer temp = Integer.valueOf(numberonly);		
			
		if(temp <= 19)
		{	
			String Moisturizer = "body > div > div.row.justify-content-center.top-space-20 > div:nth-child(1) > a > button";
			String header_Title = "body > div.container > div:nth-child(1) > h2";
			String title_name = "moisturizers";
			page_verify(Moisturizer,header_Title,title_name);						
						
			
			//
			String product_1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/p[1]")).getText();
			String product_2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[1]")).getText();
			String product_3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/p[1]")).getText();
			String product_4 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/p[1]")).getText();
			String product_5 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/p[1]")).getText();
			String product_6 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/p[1]")).getText();			
			String[] products = {product_1, product_2, product_3, product_4, product_5, product_6};			
			
			String productprice_1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/p[2]")).getText();
			String productprice_2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[2]")).getText();
			String productprice_3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/p[2]")).getText();
			String productprice_4 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/p[2]")).getText();
			String productprice_5 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/p[2]")).getText();
			String productprice_6 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/p[2]")).getText();
			String numberonly_1 = productprice_1.replaceAll("[^0-9]", "");
			String numberonly_2 = productprice_2.replaceAll("[^0-9]", "");
			String numberonly_3 = productprice_3.replaceAll("[^0-9]", "");
			String numberonly_4 = productprice_4.replaceAll("[^0-9]", "");
			String numberonly_5 = productprice_5.replaceAll("[^0-9]", "");
			String numberonly_6 = productprice_6.replaceAll("[^0-9]", "");			
		
			Integer price_1 = Integer.valueOf(numberonly_1);
			Integer price_2 = Integer.valueOf(numberonly_2);
			Integer price_3 = Integer.valueOf(numberonly_3);
			Integer price_4 = Integer.valueOf(numberonly_4);
			Integer price_5 = Integer.valueOf(numberonly_5);
			Integer price_6 = Integer.valueOf(numberonly_6);
			
			String tobesearched_Almond = "Almond";			
			String tobesearched_Aloe = "Aloe";
			int priceslist[] = {price_1, price_2, price_3, price_4, price_5,price_6};
			
			//
			
			//productswithAloe
			int index = 0;
			String productswithAloe = " ";			
			ArrayList product_list_Aloe = new ArrayList();
			for(int i = 0; i < products.length;i++) {
				if(products[i].contains(tobesearched_Aloe)) 
				{	
					index=i;
					productswithAloe = products[index].toString();
					product_list_Aloe.add(productswithAloe);					
				}
			}
			System.out.println("Products that contains Aloe: " +product_list_Aloe);
			//prices for productswithAloe			
			int index_prices_aloe =0;
			List<Integer> price_list_Aloe = new ArrayList<>();			
			for(int i = 0; i < priceslist.length;i++) {
				if(products[i].contains(tobesearched_Aloe)) 
				{	index_prices_aloe = i;	
				int pricesfor_productswithAloe = priceslist[index_prices_aloe];
				price_list_Aloe.add(pricesfor_productswithAloe);				
				}				
			}	
			System.out.println("Price list for Products that contains Aloe: " +price_list_Aloe);
			
			
			//productswithAlmond
			String productswithAlmond = " ";
			ArrayList product_list_Almond = new ArrayList();
			for(int i = 0; i < products.length;i++) {
				if(products[i].contains(tobesearched_Almond)||products[i].contains("almond")) 
				{	
					index=i;
					productswithAlmond = products[index].toString();
					product_list_Almond.add(productswithAlmond);
				}
			}
			System.out.println("Products that contains Almond: "+product_list_Almond);
			//prices for productswithAlmond
			int index_prices_almond =0;
			List<Integer> price_list_Almond = new ArrayList<>();
			for(int i = 0; i < priceslist.length;i++) {
				if(products[i].contains(tobesearched_Almond)||products[i].contains("almond")) 
				{	index_prices_almond = i;
				int pricesfor_productswithAlmond = priceslist[index_prices_almond];	
				price_list_Almond.add(pricesfor_productswithAlmond);
				
				}
			}
			System.out.println("Prices for Products that contains Almond: " +price_list_Almond);
		
			
			//pick Two least expensive Moisturizers
			int least_price_Aloe = Integer.MAX_VALUE;			
			for(int n: price_list_Aloe ) 
			{	
				if(n< least_price_Aloe) {				
					least_price_Aloe=n;
				}				
			}
			//System.out.println("Least price for the Moisturizer that containes Aloe: "+least_price_Aloe);
			
			int least_price_Almond = Integer.MAX_VALUE;			
			for(int n: price_list_Almond ) 
			{	
				if(n< least_price_Almond) {				
					least_price_Almond=n;
				}				
			}
			//System.out.println("Least price for the Moisturizer that containes Almond: "+least_price_Almond);
			
			//
			int index_aloe = 0;
			for(int i = 0; i < products.length;i++) {
				if(priceslist[i]==(least_price_Aloe)) 
				{	
					index_aloe=i;
					addtocart(index_aloe);
				}
			}
			System.out.println("Least expensive moisturizer contains Aloe is: "+products[index_aloe]+" at price "+least_price_Aloe);
			
			int index_almond =0;
			for(int i = 0; i < products.length;i++) {
				if(priceslist[i]==(least_price_Almond)) 
				{	
					index_almond=i;	
					addtocart(index_almond);
				}
			}
			System.out.println("Least expensive moisturizer contains Almond is: "+products[index_almond]+" at price "+least_price_Almond);
				
			
			WebElement cart = driver.findElement(By.xpath("/html/body/nav/ul/button"));	
			Actions action = new Actions(driver);			
			action.moveToElement(cart);
			action.click();
			action.perform();
			Thread.sleep(2000);
			
			String get_title_checkout="/html/body/div[1]/div[1]/h2";
			String get_name_item="/html/body/div[1]/div[2]/table/thead/tr/th[1]";			
			String get_name_price="/html/body/div[1]/div[2]/table/thead/tr/th[2]";
			String get_item1 = "/html/body/div[1]/div[2]/table/tbody/tr[1]/td[1]";
			String get_price1 = "/html/body/div[1]/div[2]/table/tbody/tr[1]/td[2]";
			String get_item2 = "/html/body/div[1]/div[2]/table/tbody/tr[2]/td[1]";
			String get_price2 = "/html/body/div[1]/div[2]/table/tbody/tr[2]/td[2]";
						
			verify_titles(get_title_checkout,"checkout");			
			verify_titles(get_name_item,"item");			
			verify_titles(get_name_price,"price");
			
			
			verify_titles(get_item1,products[index_aloe]);
			verify_titles(get_price1,""+least_price_Aloe);				
			
			verify_titles(get_item2,products[index_almond]);
			verify_titles(get_price2,""+least_price_Almond);
			
			String get_totalprice = " ";
			get_totalprice = driver.findElement(By.cssSelector("#total")).getText();			
			if(get_totalprice.contains("Total: Rupees "+(least_price_Aloe+least_price_Almond)))
			{
				System.out.println("Price matches: "+get_totalprice);
			}
			else
			{
				System.out.println("Prices didn't match as expected - "+(least_price_Aloe+least_price_Almond));
			}
			
			Paywithcard_form();
			
			
		}
		else if(temp >= 34)
		{
			String Sunscreen = "body > div > div.row.justify-content-center.top-space-20 > div.text-center.col-4.offset-4 > a > button";
			String header_Title = "body > div.container > div:nth-child(1) > h2";
			String title_name = "sunscreens";
			page_verify(Sunscreen,header_Title,title_name);
			
			//
			String product_1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/p[1]")).getText();
			String product_2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[1]")).getText();
			String product_3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/p[1]")).getText();
			String product_4 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/p[1]")).getText();
			String product_5 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/p[1]")).getText();
			String product_6 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/p[1]")).getText();			
			String[] products = {product_1, product_2, product_3, product_4, product_5, product_6};			
			
			String productprice_1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/p[2]")).getText();
			String productprice_2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[2]")).getText();
			String productprice_3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/p[2]")).getText();
			String productprice_4 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/p[2]")).getText();
			String productprice_5 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/p[2]")).getText();
			String productprice_6 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/p[2]")).getText();
			String numberonly_1 = productprice_1.replaceAll("[^0-9]", "");
			String numberonly_2 = productprice_2.replaceAll("[^0-9]", "");
			String numberonly_3 = productprice_3.replaceAll("[^0-9]", "");
			String numberonly_4 = productprice_4.replaceAll("[^0-9]", "");
			String numberonly_5 = productprice_5.replaceAll("[^0-9]", "");
			String numberonly_6 = productprice_6.replaceAll("[^0-9]", "");			
		
			Integer price_1 = Integer.valueOf(numberonly_1);
			Integer price_2 = Integer.valueOf(numberonly_2);
			Integer price_3 = Integer.valueOf(numberonly_3);
			Integer price_4 = Integer.valueOf(numberonly_4);
			Integer price_5 = Integer.valueOf(numberonly_5);
			Integer price_6 = Integer.valueOf(numberonly_6);
			
			String tobesearched_spf50 = "SPF-50";
			String tobesearched_spf30 = "SPF-30";			
			int priceslist[] = {price_1, price_2, price_3, price_4, price_5,price_6};
			
			//
			//productswithSPF50
			int index = 0;
			String productswithSPF50 = " ";			
			ArrayList product_list_SPF50 = new ArrayList();
			for(int i = 0; i < products.length;i++) {
				if(products[i].contains(tobesearched_spf50)) 
				{	
					index=i;
					productswithSPF50 = products[index].toString();
					product_list_SPF50.add(productswithSPF50);					
				}
			}
			System.out.println("Products that contains SPF-50: " +product_list_SPF50);
			//prices for productswithAloe			
			int index_prices_spf50 = 0;
			List<Integer> price_list_spf50 = new ArrayList<>();			
			for(int i = 0; i < priceslist.length;i++) {
				if(products[i].contains(tobesearched_spf50)) 
				{	index_prices_spf50 = i;	
				int pricesfor_productswithSPF50 = priceslist[index_prices_spf50];
				price_list_spf50.add(pricesfor_productswithSPF50);				
				}				
			}	
			System.out.println("Price list for Products that contains SPF-50: " +price_list_spf50);
			
			//productswithspf30
			String productswithspf30 = " ";
			ArrayList product_list_spf30 = new ArrayList();
			for(int i = 0; i < products.length;i++) {
				if(products[i].contains(tobesearched_spf30))//||products[i].contains("almond")) 
				{	
					index=i;
					productswithspf30 = products[index].toString();
					product_list_spf30.add(productswithspf30);
				}
			}
			System.out.println("Products that contains SPF-30: "+product_list_spf30);
			//prices for productswithspf30
			int index_prices_spf30 =0;
			List<Integer> price_list_spf30 = new ArrayList<>();
			for(int i = 0; i < priceslist.length;i++) {
				if(products[i].contains(tobesearched_spf30))//||products[i].contains("almond")) 
				{	index_prices_spf30 = i;
				int pricesfor_productswithspf30 = priceslist[index_prices_spf30];	
				price_list_spf30.add(pricesfor_productswithspf30);
				
				}
			}
			System.out.println("Prices for Products that contains SPF-30: " +price_list_spf30);
			
			
			//pick Two least expensive Moisturizers
			int least_price_spf50 = Integer.MAX_VALUE;			
			for(int n: price_list_spf50 ) 
			{	
				if(n< least_price_spf50) {				
					least_price_spf50=n;
				}				
			}
			//System.out.println("Least price for the Moisturizer that containes Aloe: "+least_price_spf50);
			
			int least_price_spf30 = Integer.MAX_VALUE;			
			for(int n: price_list_spf30 ) 
			{	
				if(n< least_price_spf30) {				
					least_price_spf30=n;
				}				
			}
			//System.out.println("Least price for the Moisturizer that containes Almond: "+least_price_spf30);
			
			//
			int index_spf50 = 0;
			for(int i = 0; i < products.length;i++) {
				if(priceslist[i]==(least_price_spf50)) 
				{	
					index_spf50=i;
					addtocart(index_spf50);
				}
			}
			System.out.println("Least expensive Sunscreen that contains SPF-50 is: "+products[index_spf50]+" at price "+least_price_spf50);
			
			int index_spf30 =0;
			for(int i = 0; i < products.length;i++) {
				if(priceslist[i]==(least_price_spf30)) 
				{	
					index_spf30=i;	
					addtocart(index_spf30);
				}
			}
			System.out.println("Least expensive Sunscreen that contains SPF-30 is: "+products[index_spf30]+" at price "+least_price_spf30);
			
			WebElement cart = driver.findElement(By.xpath("/html/body/nav/ul/button"));	
			Actions action = new Actions(driver);			
			action.moveToElement(cart);
			action.click();
			action.perform();
			Thread.sleep(2000);
			
			String get_title_checkout="/html/body/div[1]/div[1]/h2";
			String get_name_item="/html/body/div[1]/div[2]/table/thead/tr/th[1]";			
			String get_name_price="/html/body/div[1]/div[2]/table/thead/tr/th[2]";
			String get_item1 = "/html/body/div[1]/div[2]/table/tbody/tr[1]/td[1]";
			String get_price1 = "/html/body/div[1]/div[2]/table/tbody/tr[1]/td[2]";
			String get_item2 = "/html/body/div[1]/div[2]/table/tbody/tr[2]/td[1]";
			String get_price2 = "/html/body/div[1]/div[2]/table/tbody/tr[2]/td[2]";
			
			
			verify_titles(get_title_checkout,"checkout");			
			verify_titles(get_name_item,"item");			
			verify_titles(get_name_price,"price");
			
			verify_titles(get_item1,products[index_spf50]);
			verify_titles(get_price1,""+least_price_spf50);				
			
			verify_titles(get_item2,products[index_spf30]);
			verify_titles(get_price2,""+least_price_spf30);
			
			String get_totalprice = " ";
			get_totalprice = driver.findElement(By.cssSelector("#total")).getText();			
			if(get_totalprice.contains("Total: Rupees "+(least_price_spf50+least_price_spf30)))
			{
				System.out.println("Price matches: "+get_totalprice);
			}
			else
			{
				System.out.println("Prices didn't match as expected - "+(least_price_spf50+least_price_spf30));
			}
			
			Paywithcard_form();
			
		}

	}
	
	
	public static void addtocart(int index) throws InterruptedException
	{
		WebElement addtocartbutton_1_ = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/button"));
		WebElement addtocartbutton_2_ = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/button"));
		WebElement addtocartbutton_3_ = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/button"));
		WebElement addtocartbutton_4_ = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/button"));
		WebElement addtocartbutton_5_ = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/button"));
		WebElement addtocartbutton_6_ = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/button"));
		
		Actions action = new Actions(driver);
		switch(index){
			case 0:			
				action.moveToElement(addtocartbutton_1_);
				action.click();
				action.perform();
				Thread.sleep(2000);
				break;
			case 1:						
							
				action.moveToElement(addtocartbutton_2_);
				action.click();
				action.perform();
				Thread.sleep(2000);
				break;
			case 2:						
							
				action.moveToElement(addtocartbutton_3_);
				action.click();
				action.perform();
				Thread.sleep(2000);
				break;
			case 3:						
							
				action.moveToElement(addtocartbutton_4_);
				action.click();
				action.perform();
				Thread.sleep(2000);
				break;
			case 4:						
							
				action.moveToElement(addtocartbutton_5_);
				action.click();
				action.perform();
				Thread.sleep(2000);
				break;
			case 5:						
							
				action.moveToElement(addtocartbutton_6_);
				action.click();
				action.perform();
				Thread.sleep(2000);
				break;
			default:
				System.out.println("Not valid!");				
		}
	}
	
	
	public static void Paywithcard_form() throws InterruptedException {
		String form = "/html/body/div[1]/div[3]/form/button";
		WebElement paywithcard = driver.findElement(By.xpath(form));
		
		Actions action = new Actions(driver);			
		action.moveToElement(paywithcard);
		action.click();
		action.perform();
		Thread.sleep(2000);
		
		driver.switchTo().frame("stripe_checkout_app");		
		String get_headertitle = "/html/body/div[3]/form/div[2]/div/div[1]/header/div/div[3]/h1";
		String submit = "#submitButton";
		
		verify_titles(get_headertitle, "Stripe.com");
		
		WebElement input_Email = driver.findElement(By.id("email"));
		input_Email.sendKeys("NKS@gmail.com");
		Thread.sleep(2000);
		
		WebElement input_cardnumber = driver.findElement(By.id("card_number"));
		input_cardnumber.sendKeys("5555");		
		Thread.sleep(2000);
		input_cardnumber.sendKeys("5555");
		Thread.sleep(2000);
		input_cardnumber.sendKeys("5555");
		Thread.sleep(2000);
		input_cardnumber.sendKeys("4444");
		Thread.sleep(2000);
		
		WebElement input_mm_exp = driver.findElement(By.xpath("//*[@id=\"cc-exp\"]")); 
		input_mm_exp.sendKeys("08");
		Thread.sleep(2000);
		input_mm_exp.sendKeys("23");
		
		WebElement input_cvv = driver.findElement(By.id("cc-csc"));
		input_cvv.sendKeys("123");
		Thread.sleep(2000);
		
		WebElement input_zipcode = driver.findElement(By.id("billing-zip"));
		input_zipcode.sendKeys("99085");
		Thread.sleep(2000);		
		WebElement submit_ = driver.findElement(By.cssSelector(submit));
		action.moveToElement(submit_);
		action.click();
		action.perform();
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		
		String get_paymentsuccess = "/html/body/div/div[1]/h2"; 
		String confirmationtext = "/html/body/div[1]/div[2]/p";		
		
		verify_titles(get_paymentsuccess, "payment success");
		
		Thread.sleep(2000);
		verify_titles(confirmationtext, "Your payment was successful. You should receive a follow-up call from our sales team.");
		Thread.sleep(2000);
		driver.close();
		driver.quit();
				
		
	}
	
	public static void verify_titles(String get_title, String expected_titlename) {
		String get_titlename = driver.findElement(By.xpath(get_title)).getText();	
		if(get_titlename.equalsIgnoreCase(expected_titlename))
		{
			System.out.println("Item Title matches: "+expected_titlename);
		}
		else
		{
			System.out.println("Item Title didn't match as expected - "+expected_titlename);
		}	
	}
	
	
	
	public static void page_verify(String product_button, String get_header_Title, String titlename) throws InterruptedException
	{	
		WebElement product_link = driver.findElement(By.cssSelector(product_button)); 
		Actions action = new Actions(driver);			
		action.moveToElement(product_link);
		action.click();
		action.perform();
		Thread.sleep(2000);
						
		String expected_titlename = driver.findElement(By.cssSelector(get_header_Title)).getText();
		if(expected_titlename.equalsIgnoreCase(titlename))
		{
			System.out.println("Title matches: "+expected_titlename);
		}
		else
		{
			System.out.println("Title didn't match as expected - "+expected_titlename);
		}			
	}

		
}
  
