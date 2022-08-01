
import Mysql.MySqlDatabase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */

public class MyDB {
    MySqlDatabase ms=null;
    public MyDB()
    {
         ms=new MySqlDatabase("PropTan","property_type", "root", "root");
    }
    public int Insert(String id,String Name,String des)
    {
      return   ms.Insert(new String[]{id,Name,des});
    }
}
