package com.csii.pe.tool.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * PropUtils is used to get message from properties file.
 * @author tzbank
 * @see Properties
 */
public class PropUtils {
	private Properties props = new Properties();
	private Log log = LogFactory.getLog(PropUtils.class);

	public PropUtils() {
		Reader reader = null;
		try {
			InputStream stream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("resource/appmsg_zh_CN.properties");
			reader = new InputStreamReader(stream);
			props.load(reader);
		} catch (FileNotFoundException e) {
			log.info(e.getMessage());
		} catch (IOException e) {
			log.info(e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();// close reader
					reader = null;
				} catch (IOException e) {
					log.info(e.getMessage());
				}
			}
		}
	}

	public String getText(String key) {
		return props.getProperty(key);
	}

}
