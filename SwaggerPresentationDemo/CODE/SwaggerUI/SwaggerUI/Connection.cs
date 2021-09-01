using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace SwaggerUI
{ 
    /// <summary>
    /// gfgf
    /// </summary>
    public class Connection
    {
        /// <summary>
        /// fgfg
        /// </summary>
        /// <returns></returns>
        public SqlConnection OpenConnection()
        {
            SqlConnection Connection = new SqlConnection("Data Source = HP-PAVILION-GAM; Initial Catalog = SwaggerDemo; Integrated Security = True");
            Connection.Open();
            return Connection;
        }
        public SqlCommand CreateQuery(string Query)
        {
            SqlCommand Cmd = new SqlCommand(Query, OpenConnection());
            return Cmd;
        }
    }
}
