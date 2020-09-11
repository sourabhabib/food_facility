package com.facility.rest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DocrootUtils {	

	private static final Logger LOGGER = LoggerFactory.getLogger(DocrootUtils.class);

	//AWS PATH

//	public static final String CONF_DIR = System.getProperty("catalina.base") + File.separator + "webapps" + File.separator + "conf" + File.separator + "afc_conf";

	//public static final String CONF_DIR = "D:\\Logistics_REST\\Logistics_REST\\Developement\\Logistics_api\\conf";

	public static final String CONF_DIR = "C:\\afc_conf";


	public static final String UPLOADS = File.separator + "resources" + File.separator + "uploads";
	public static final String IMAGES = UPLOADS + File.separator + "images";
	public static final String DOCUMENTS = UPLOADS + File.separator + "documents";
	public static final String FILE_BASE64 = "base64";
	public static final String FILE_NAME = "filename";

	public static final String DOCUMENT_ROOT;
	public static final String DOMAIN_REST;
	public static final String CONTEX_REST;
	public static final String DOMAIN_WEB;
	public static final String CONTEX_WEB;

	static {

		String docRoot = "", domainRest = "", contextRest = "", domainWeb = "", contextWeb = "";

		try {
			Properties properties = new Properties();

			LOGGER.info("Reading domain-conf.properties");
			// Load a properties file
			properties.load(new FileInputStream(new File(CONF_DIR + File.separator + "domain-conf.properties")));

			docRoot = properties.getProperty("app.resource.docroot"); 
			//			
			domainRest = properties.getProperty("app.rest.domain");
			domainWeb = properties.getProperty("app.web.domain");

			contextRest = properties.getProperty("app.rest.context");
			contextWeb = properties.getProperty("app.web.context");

			LOGGER.info(properties.toString());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}

		DOCUMENT_ROOT = docRoot;
		DOMAIN_REST = domainRest;
		CONTEX_REST = contextRest;
		DOMAIN_WEB = domainWeb;
		CONTEX_WEB = contextWeb;
	}

	/**
	 * @param imageFile
	 * @return boolean
	 * @throws IOException
	 */
	public static boolean deleteFile(final File imageFile) throws IOException{

		boolean status = false;
		if(imageFile.exists())
			status = imageFile.delete();
		return status;
	}

	/**
	 * @param image
	 * @param resourcePath
	 * @param name
	 * @return File
	 * @throws IOException
	 */
	public static File fileUpload(final byte[] fileContents, final File parentDir, final String name) throws IOException{

		final File file = new File(parentDir, name);
		FileUtils.writeByteArrayToFile(file, fileContents);
		return file;
	}

	/**
	 * @param parentDir <pre> Parend dir object</pre>
	 * @param newDir <pre> New Dir Name</pre>
	 * @param create <pre> Create new dir if not exist</pre>
	 * @return File
	 * @throws IOException
	 */
	public static File getDir(final File parentDir, final String newDir, boolean create) throws IOException{

		File dir = new File(parentDir, newDir);
		if(!dir.exists()){
			if(create)
				dir.mkdir();
			else
				dir = null;
		}

		return dir;
	}

	/**
	 * @param dir <pre>Dorectory to be deleted</pre>
	 * @param empty <pre>Delete if empty dir</pre>
	 * @return boolean
	 * @throws IOException
	 */
	public static boolean deleteDir(final File dir, final boolean empty) throws IOException{

		boolean status = false;
		if(dir.exists()){
			if(empty){
				status = dir.delete();
			} else {
				File [] childs = dir.listFiles();
				if(childs != null && childs.length > 0){
					for(File child : childs)
						if(child.isDirectory())
							deleteDir(child, false);
						else
							deleteFile(child);
				}
				dir.delete();
			}

		}

		return status;
	}
}
