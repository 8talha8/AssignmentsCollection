package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLDecoder;
import java.net.UnknownHostException;
//import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
//import org.hsqldb.Session;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.cmss.fullerton.crmnext.ArrayOfSearchCondition;
import com.cmss.fullerton.crmnext.FieldOperation;
import com.cmss.fullerton.crmnext.ObjectFactory;
import com.cmss.fullerton.crmnext.Query;
import com.cmss.fullerton.crmnext.SearchCondition;
import com.cmss.fullerton.flexi.VO.DrwDwnReq;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

//import in.cmss.followup.bean.db.Project;
//import in.cmss.followup.bean.request.SerializedFormRequest;

@Component
public class Utility {

	//"yyyy-MM-dd' 'HH:mm:ss"
	private static final Logger log = LogManager.getLogger(Utility.class);
	static int counter = 0;
	ClassLoader classLoader = getClass().getClassLoader();
	//static String testing = (String) AppConfig.configMap.get(ExceptionConstants.PROPERTY_KEY).get(ExceptionConstants.TESTING); 
	
	public static void main(String arg[]) throws Exception {
		int i = -10;
		String response = "{\"AUTHENTICATION\":{\"APP_NAME\":\"MIFIN\",\"APP_PASS\":\"PASS@123\",\"IPADDRESS\":\"10.1.1.3\",\"DEVICE_ID\":\"CUSTOMERAPP\",\"LONGITUDE\":\"77.3877269\",\"LATITUDE\":\"28.6127356\"},\"LOANINFO\":{\"CIF_NO\":\"1000000021\",\"SANCTION_REF_NO\":\"1000000154\",\"MERCHANT_CODE\":\"\",\"AUTO_DISBURSAL_FLAG\":\"N\",\"DRAWDOWN_AMOUNT\":\"100000\",\"ROI\":\"14.5\",\"INSTALLMENT_TYPE\":\"INTY000011\",\"TENOR\":\"5\",\"INTEREST_TYPE\":\"IT00000001\",\"REPAYMENT_MODE\":\"P\",\"REPAYMENT_FREQUENCY\":\"M\"},\"CHARGES\":{\"CHARGE_DETAILS\":[{\"CHARGEID\":\"CHRG000151\",\"CHARGEAMOUNT\":\"1000\"}]}}";
		System.out.println(">>"+iterateNValidateJSONObj(response, "^.*$"));
		System.exit(0);
		String a= new String("abc");
		BigDecimal pp_amount =new BigDecimal(0);
		System.out.println(pp_amount.setScale(2, RoundingMode.CEILING));//Double.parseDouble("0.1")<1);
		System.out.println("0>>"+DateUtility.oneDateStrToOther(Utility.getValueForKeyFromJson(response,"MIFIN_BUSINESS_DATE",1),"yyyy-MM-dd HH:mm:ss.SSS","dd-MMM-yyyy"));
		System.exit(0);
		System.out.println("2>>"+getValueForKeyFromJson(response, "STATUS",1));
		
		double d2 = 0.0;
		int j = (int) d2;
		System.out.println(">>>"+new BigDecimal("1.566"));
//		System.out.println("?????"+j)1;
//		String callBackUrl = "sdjkfhdjks.com/hsdjkfh/hhhhhhh";
//		String currentUrl ="sdjkfhdflexihkdfdskj";// request.getAttribute("javax.servlet.forward.request_uri").toString()	;
//		String redirectURL;
//		if(currentUrl.contains("flexi")) {
//			String tempUrl = callBackUrl.substring(0,callBackUrl.indexOf(".com"));
//			callBackUrl = tempUrl+".com/flexi"+callBackUrl.substring(callBackUrl.indexOf(".com")+4);
//		System.out.println(callBackUrl+"<<callBackUrl");
//		}
//		
//		HashMap<String, Object> sessionObj= new HashMap<String, Object>();
//		sessionObj.put("fdsf", null);
//		System.out.println(sessionObj);
		String d= DateUtility.oneDateStrToOther("2019-08-05 00:00:00.0", "yyyy-MM-dd' 'HH:mm:ss", "dd-MMM-yyyy");
String h = "98 "; 
		System.out.println(">>"+h.trim()+"<<");
		System.out.println(new Integer ("001637762159"));
		DateUtility.parseStringToDateofbirth("2017-07-13T05:34:45","yyyy-MM-dd'T'HH:mm:ss").getTime();
		if(i==-2){
			
			System.out.println(ObjTojson(new DrwDwnReq()));
			System.out.println(jsonToObj("{\"AUTHENTICATION\":{\"APP_NAME\":\"MIFIN\",\"APP_PASS\":\"PASS@123\",\"IPADDRESS\":\"10.1.1.3\",\"DEVICE_ID\":\"CUSTOMERAPP\",\"LONGITUDE\":\"77.3877269\",\"LATITUDE\":\"28.6127356\"},\"LOANINFO\":{\"CIF_NO\":\"1000000021\",\"SANCTION_REF_NO\":\"1000000154\",\"MERCHANT_CODE\":\"\",\"AUTO_DISBURSAL_FLAG\":\"N\",\"DRAWDOWN_AMOUNT\":\"100000\",\"ROI\":\"14.5\",\"INSTALLMENT_TYPE\":\"INTY000011\",\"TENOR\":\"5\",\"INTEREST_TYPE\":\"IT00000001\",\"REPAYMENT_MODE\":\"P\",\"REPAYMENT_FREQUENCY\":\"M\"},\"CHARGES\":{\"CHARGE_DETAILS\":[{\"CHARGEID\":\"CHRG000151\",\"CHARGEAMOUNT\":\"1000\"}]}}", DrwDwnReq.class));
		}
		if (i == -1){
			ObjectFactory o=new ObjectFactory();
			ArrayOfSearchCondition arrayOfSearchCondition = new ArrayOfSearchCondition();
			SearchCondition searchCondition = new SearchCondition();
//			searchCondition.setFieldName("AccountID");
			searchCondition.getFieldName();
//			searchCondition.setOperation(FieldOperation.EQUAL);
			searchCondition.getOperation();
//			searchCondition.setValue("1234567");
			searchCondition.getValue();
			arrayOfSearchCondition.getSearchCondition()
			.add(searchCondition);
			JAXBElement<ArrayOfSearchCondition> jbArrayOfSearchCondition = o.createQueryCondition(arrayOfSearchCondition);
			
			jbArrayOfSearchCondition.setValue(arrayOfSearchCondition);
			Query q= new Query();
			
			q.setCondition(jbArrayOfSearchCondition);
			System.out.println(xmlMarshal(q, q.getClass()));
			
			Query q2 = (Query) xmlUnmarshal(Query.class, xmlMarshal(q, q.getClass()));
			
			System.out.println(q2.getCondition().getValue().getSearchCondition().get(0).getValue());
			//System.out.println(xmlUnmarshal(Query.class, xmlMarshal(q, q.getClass())));//xmlMarshal(q, q.getClass())));
		}
		
	

	}
	
	
	public  File getFileFromRes(String filename) {
		
		File file = new File(classLoader.getResource(filename).getFile());
		log.info("@" + file.getAbsolutePath());
	
		return file;
	}
	public static String getAppFolderPath() throws UnsupportedEncodingException {
		String path = Utility.class.getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		System.out.println(fullPath);
		System.out.println(pathArr[0]);
		return pathArr[0];
		//fullPath = pathArr[0];
		
		/*String reponsePath = "";
		// to read a file from webcontent
		reponsePath = new File(fullPath).getPath() + File.separatorChar + "newfile.txt";
		return reponsePath;*/
		}
	
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	public static String lstObjTojson(List<?> obj) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.EAGER_DESERIALIZER_FETCH, false);
		String json = objectMapper.writeValueAsString(obj);
		log.info("1. Convert  object to Json");
		log.info(json);
		return json;

	}

	public static String ObjTojson(Object obj) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		String json = objectMapper.writeValueAsString(obj);
		log.info("1. Convert  object to Json");
		log.info(json);
		return json;

	}
	public static Object jsonToObj(String input, Class<?> myClass) throws IOException {

		// AppPropertyConstants.log.info(myClass.isArray() + "<<<<<<<<<<<");

		/* Constructor<?> ctor = myClass.getClass().getConstructor(); */

		Object myObject;

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		//JsonNode jsonNode = mapper.readTree(input);
		myObject = mapper.readValue(input, myClass);
		return myObject;

	}

	public static String getSHA512Hash(String passwordToHash, String salt)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String generatedPassword = null;
		try {

			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt.getBytes("UTF-8"));
			byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw e;
		}

		return generatedPassword;
	}

	public static Timestamp sqlDateFormater(String date, String formate) throws Exception {
		try {

			SimpleDateFormat dateFormat = new SimpleDateFormat(formate);
			
			Date parsedDate = dateFormat.parse(date);
			return new java.sql.Timestamp(parsedDate.getTime());

			/*
			 * SimpleDateFormat format = new SimpleDateFormat(
			 * "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
			 * format.setTimeZone(TimeZone.getTimeZone("UTC"));
			 */
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}
	
	public static Timestamp getCurrentDate(String formate) throws Exception {
		try {
		    //  final int DATE_EPOCH_DIFF=0;
			//java.util.Date dt=new java.util.Date(System.currentTimeMillis()+DATE_EPOCH_DIFF);
	        
//	        java.sql.Timestamp today = new Timestamp(System.currentTimeMillis());
	        
	        return new java.sql.Timestamp(System.currentTimeMillis());
			 
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public static BigDecimal  roundAmnt(BigDecimal amnt){
		  return amnt.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	  }
	
	public static Properties getProperty(String propFileName) throws IOException {
		String result = "";
		InputStream inputStream = null;
		log.info("INNNNNNNNNN");
		Properties prop = new Properties();

		try {

			// String propFileName = "config.properties";
			try {
				inputStream = new FileInputStream(propFileName);
				// inputStream =
				// getClass().getClassLoader().getResourceAsStream(propFileName);
			} catch (Exception e) {

				// inputStream = new FileInputStream(propFileName);

			}

			if (inputStream != null) {
				prop.load(inputStream);

			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return prop;
	}


	

	
	public static String getClientIpAddress(HttpServletRequest request) {
	    String xForwardedForHeader = request.getHeader("X-Forwarded-For");
	    if (xForwardedForHeader == null) {
	        return request.getRemoteAddr();
	    } else {
	        // As of https://en.wikipedia.org/wiki/X-Forwarded-For
	        // The general format of the field is: X-Forwarded-For: client, proxy1, proxy2 ...
	        // we only want the client
	        return new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
	    }
	}
	
	public static String xmlMarshal(Object obj, Class<?> myClass)
            throws IOException, JAXBException {
        JAXBContext context;
        StringWriter writer = new StringWriter();

        context = JAXBContext.newInstance(myClass);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
       try{
    	   m.marshal(obj, writer);
       }catch (Exception e) {
    	   log.error("XML Obj is Not root element ");
    	   System.out.println("XML Obj is Not root element ");
    	   m.marshal(new JAXBElement( new QName("","NoRootElementWrapper"),myClass,obj), writer);
	}
        
        String result = writer.toString();
        writer.close();
        return result;
    }
 
    // Import: Unmarshalling
    public static Object xmlUnmarshal( Class<?> myClass, String input) throws JAXBException {
    	
    	/*Source source = new StreamSource(new StringReader(input));
		JAXBContext jc = JAXBContext.newInstance(myClass);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		Query q2 = (Query) unmarshaller.unmarshal(source);
    	*/
       
        return JAXBContext.newInstance(myClass).createUnmarshaller().unmarshal(new StringReader(input));
 
 
    }
    
    public static String getValueForKeyFromJson(String json, String key, int position){
    	//String[] res= {"",json};
//    	for(int i= 0;i<=position; i++) {
//    		System.out.println("0>>"+res[0]);
//    		System.out.println("1>>"+res[1]);
    	String[]  res= json.split(key+"\"[:]\\s*\"");
//    	 System.out.println("Res0>>"+res[0]);
//    	 System.out.println("Res>>"+res[1]);
//    	}
    	System.out.println("1>>"+res[1]);
    	res = res[position].split("\"");
    	//[^\"]*\"");//(\".*\")");
    	System.out.println("1>>"+res[0]);
    	return res[0];
    	
    }
    
    public static boolean firstIsBeforeSecond(Date date1, Date date2){
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return cal1.before(cal2);
        
        }
    public static boolean iterateNValidateJSONObj(String jsonStr, String validationType){
		JSONObject jsonObject=null;
		boolean flag= true;
		try{
			 jsonObject = new JSONObject(jsonStr.trim());
		
		}catch (Exception e) {
			flag=  iterateNValidateJSONArray( jsonStr.trim(),  validationType);
			if(!flag) {
				return flag;
			}
		}
		Iterator<String> keys = jsonObject.keys();
//		for(int i = 0; i<jsonObject.names().length(); i++){
//			System.out.println( "key = " + jsonObject.names().getString(i) + " value = " + jsonObject.get(jsonObject.names().getString(i)));
//		}
		while(keys.hasNext()) {
		    String key = keys.next();
		    System.out.println("key= "+key);
		    if (jsonObject.get(key) instanceof JSONObject) {
//		    	JSONObject subJson = new JSONObject(String.valueOf(jsonObject.get(key)));
			    	System.out.println("It is JSON Obj key= "+key+", value= "+jsonObject.get(key));
			    	flag= iterateNValidateJSONObj(String.valueOf(jsonObject.get(key)), validationType);
			    	if(!flag) {
						return flag;
					}
		    } else if (jsonObject.get(key) instanceof JSONArray) {
//		    	JSONObject subJson = new JSONObject(String.valueOf(jsonObject.get(key)));
		    	System.out.println("It is JSON Array key= "+key+", value= "+jsonObject.get(key));
		    	flag= iterateNValidateJSONArray( String.valueOf(jsonObject.get(key)),  validationType);
		    	if(!flag) {
					return flag;
				}
	    }else {
		    	System.out.println("This is Direct Value>>>>>>key= "+key+", value= "+jsonObject.get(key));
		    	if (!Pattern.compile(validationType).matcher(String.valueOf(jsonObject.get(key))).matches()) {
		    		System.out.println("false for "+jsonObject.get(key));
		    		return false;
		    	}
		    }
		}
	
		return true;
		
	}
    public static boolean iterateNValidateJSONArray(String jsonStr, String validationType) throws JSONException{
		boolean flag= true;
		JSONArray jsonArr ;
		try{
			jsonArr = new JSONArray(jsonStr.trim());
		
		}catch (Exception e) {
			return false;
		}
		
		for(int i=0;i<jsonArr.length();i++) {
			Object value = jsonArr.get(i);
		    System.out.println("key= "+value);
		    if (value instanceof JSONObject) {
//		    	JSONObject xx = new JSONObject(String.valueOf(value));
			    	System.out.println("It is JSON Obj value= "+value);
			    	flag=  iterateNValidateJSONObj( String.valueOf(value), validationType);
			    	if(!flag) {
						return flag;
					}
		    } else if (value instanceof JSONArray) {
		    	
		    	System.out.println("It is JSON Array value= "+value);
		    	flag=  iterateNValidateJSONArray( String.valueOf(value),  validationType);
		    	if(!flag) {
					return flag;
				}
	    }else {
	    	System.out.println("This is Direct Value value= "+value);
	    	if (!Pattern.compile(validationType).matcher(String.valueOf(value)).matches()) {
	    		System.out.println("false for "+value);	
	    		return false;
	    		
	    	}
		    }
		}
		
		return true;
		
	}

}
