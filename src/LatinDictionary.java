import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.*;
import org.jsoup.select.Elements;

import java.util.Scanner;

public class LatinDictionary {

	public static void main(String[] args) throws IOException {
		
				// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("latin.txt"));
		PrintWriter html = new PrintWriter(new FileOutputStream ("RedBookDictionary.txt"));
		String body = "";
		int count = 0;
		for(int i= 0; i<690; i++)
		{
			try{
				
					String name = "sum";
					name = scan.next();
					String site = "http://m-travnikar4.appspot.com/www.archives.nd.edu/cgi-bin/wordz.pl?keyword=" + name;
					System.out.println(i);
					Document doc = Jsoup.connect(site).timeout(1000000).get();
					body = body + "\n\n" + doc.text();
			}
			catch(HttpStatusException e){
				count++;
			}
		}
		//System.out.println(body);
		System.out.println(count);
	    html.println(body);
		html.close();
	}

}
