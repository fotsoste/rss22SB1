package fr.univrouen.rss22SB1.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;



import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import fr.univrouen.rss22SB1.exceptions.FeedAPI500Exception;

public class FeedUtil {
	
	public String loadFileXML() {
        Resource resource;
        
        try {
                // chargé la ressource index.html contenant la page d'accueil
                resource = new DefaultResourceLoader().getResource("classpath:html/index.html");
                BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()),1024);
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line).append('\n');
                }

                br.close();
                return stringBuilder.toString();
        } catch (Exception e) {
            // si la conversion en string de la page d'accueil échoue
           throw new FeedAPI500Exception("impossible de chargé la page d'accueil");
        }
        
    }

}
