
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class P_TYPE {
    
    
    private int id;
    private String name;
    private  String description;
    
    //crete the geter seter
    public Integer getId()
    {
        return id;
    }
    public  void setId(Integer ID)
    {
       this.id=ID;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String NAME)
    {
        this.name=NAME;
        
    }
    public String getDescription()
    {
        return this.description;
    }
    
    
    public void setDescription(String DESCRIPTION)
    {
        this.description=DESCRIPTION;
    }
    //crete the class constructer
    public P_TYPE(){}
    public P_TYPE(Integer ID,String NAME ,String DESCRIPTION)
    {
        this.id=ID;
        this.name=NAME;
       this.description=DESCRIPTION;
    }
    
    
    
    //create a function to insert edit revome type 
    
    public boolean execTypeQuery(String queryType,P_TYPE type)
    {
        PreparedStatement ps;
        //add a new typw
        
        if(queryType.equals("add"))
        {
            /*
            try {
                //query->insert into  property_type(name,description)values(??)
                ps=THE_CONNECTION.getTheConnection().prepareStatement("INSERT INTO  'property_type'('name','description')VALUES(?,?) ");
           
            ps.setString(1,type.getName());
            ps.setString(2, type.getDescription());
            
            
            return (ps.executeUpdate()> 0);
             
            
            } catch (SQLException ex) {
                Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                 return false;
            }
            */
        }
       
        else if(queryType.equals("edit"))
        {
            try {
                //query->UPDATE 'property_type'SET 'name'=?,'description'=? WHERE 'id'=?
                ps=THE_CONNECTION.getTheConnection().prepareStatement("UPDATE 'property_type'SET 'name'=?,'description'=? WHERE 'id'=? ");
           
            ps.setString(1,type.getName());
            ps.setString(2, type.getDescription());
            ps.setInt(3, type.getId());
            
            
            return (ps.executeUpdate()> 0);
             
            
            } catch (SQLException ex) {
                Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                 return false;
            }
            
        }
        
         else if(queryType.equals("remove"))
        {
            try {
                //query->DELET FROM 'property_type'WHERE 'id'=?
                ps=THE_CONNECTION.getTheConnection().prepareStatement("DELET FROM 'property_type'WHERE 'id'=?");
                ps.setInt(1, type.getId());
              return (ps.executeUpdate()> 0);
             
            } catch (SQLException ex) {
                Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                 return false;
            }
            
        }
        
         else 
         {
             JOptionPane.showMessageDialog(null,"Enter The Correct Query (add,edit,remove)","Invalid operation",2);
             return false;
         }
        return false;
    }
    // create a function to return a list of all type in hashmap
          public HashMap<String,Integer>getTypesMap()
          {
              HashMap<String,Integer>map= new HashMap<>();
             
              Statement st;
              ResultSet rs;
        try {
            
            st=THE_CONNECTION.getTheConnection().createStatement();
            rs=st.executeQuery("SELECT *FROM 'property_type' ");
            P_TYPE type;
            
            while(rs.next())
            {
                type=new P_TYPE(rs.getInt(1),rs.getString(2),rs.getString(3));
                
                map.put(type.getName(), type.getId());
                
                
            }        
        } catch (SQLException ex) {
            Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
        }               
              return map;
          }
    // create a function to get the type data by id
    //we can use getTypesMap()
          
       public P_TYPE getTypeById(Integer id)     

       {
              PreparedStatement ps;
             ResultSet rs;
            P_TYPE type = new P_TYPE();
             
             
             try 
             {
                 ps=THE_CONNECTION.getTheConnection().prepareStatement("SELECT * FROM 'property_type' WHERE 'id'=?");
                 ps.setInt(1,id);
                 rs=ps.executeQuery();
                 if(rs.next())
                 {    type.setId(id);
                      type.setName(rs.getString(2));
                      type.setDescription(rs.getString(3));
                 }
             } 
               catch (SQLException ex) 
               {
                 Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
       
               }   
             return type;
       }
}