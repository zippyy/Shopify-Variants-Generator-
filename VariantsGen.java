import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class VariantsGen
{
	
	public static void main(String[] args) throws MalformedURLException, IOException
	{
		String targetUrl = "https://www.oipolloi.com/collections/new-stuff/products/nike-air-max-1-97-vf-sw-light-blue-fury-lemon-wash#product";
		System.out.println(targetUrl);
		URL url = new URL(targetUrl);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		
		int t = 0;
		
		//method below prints specific part of a source code
		String inputline; 
		
		while ((inputline = in.readLine()) != null)
		{
			//prints out line with variants
			if (inputline.contains("variants") && (t == 0))
			{
				t++;
				//System.out.println(inputline);
				//System.out.println(inputline.length());
				for (int i = 0; i < inputline.length() - 1; i++)
				{		
					String a = inputline.substring(i,  i + 1);
					if (a.equals("["))
					{
						
						String idVariant = inputline.substring(i);
						for (int j = 0; j < idVariant.length() - 1 ; j++)
						{
							String idCheck = idVariant.substring(j, j + 2);
							// prints variants id
							if (idCheck.equals("id"))
							{
								System.out.print("id: " + idVariant.substring(j + 4, j + 17));
								String sizeCheck = idVariant.substring(j);
								for (int o = 0; o < sizeCheck.length()-
										12 ; o++)
								{
									//Below Prints out corresponding size to the variant still need to clean up abit.
									String size = sizeCheck.substring(o, o + 12);
									if (size.equals("public_title"))
									{
										System.out.print("---" + sizeCheck.substring(o + 15, o + 21));
										System.out.println();
										break;
									}
								}
								
								
							}
							
						}
						
						
					}
					
				}
				
			}
			
			
		}
		
		in.close();

	}
}
