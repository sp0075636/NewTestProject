package com.demo.controller;

public class Operations {
	
	public static String truncate(String param,int truncLim)
    {
           System.out.println(param.length());
           String truncVal=" ... (truncated) ... ";
           String tempVal1=null;
           String tempVal2=null;

           
           if(param.length()>truncLim && truncLim>truncVal.length())
           {
                  if(truncLim-truncVal.length()==1)
                  {
                        tempVal1=param.substring(0,1);
                        param=tempVal1+truncVal;
                  }
                  else if((truncLim-truncVal.length())%2==0)
                  {
                        tempVal1=param.substring(0,(truncLim-truncVal.length())/2);
                        tempVal2=param.substring((param.length()-tempVal1.length()),param.length());
                        param=tempVal1+truncVal+tempVal2;
                  }
                  else
                  {
                        
                        tempVal1=param.substring(0,((truncLim-truncVal.length())/2)+1);
                        tempVal2=param.substring((param.length()-(tempVal1.length())+1),param.length());
                        param=tempVal1+truncVal+tempVal2;
                  }
           }
           
           
           return param;
           
           
    }

	

}
