using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace SwaggerUI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EmployeeController : ControllerBase
    {
        // GET: api/<EmployeeController>
        /// <summary>
        /// Gets all employees from database
        /// </summary>
        /// <returns>returns IEnumerable<Employee></returns>
        [HttpGet]
        public IEnumerable<Employee> Get()
        {
            Connection connection = new Connection();
            var dt = new DataTable();
            using (connection.OpenConnection())
            {
                string query = "select * from Employee";
                SqlCommand command = connection.CreateQuery(query);
                dt.Load(command.ExecuteReader());
            }
            foreach(DataRow row in dt.Rows)
            {
                yield return new Employee
                {
                    Date = Convert.ToDateTime(row["Date"]),
                    EmployeeId = Convert.ToInt32(row["Id"]),
                    Name = row["Name"].ToString()
                };
            }
        }

        // GET api/<EmployeeController>/5
        /// <summary>
        /// Select with id
        /// </summary>
        /// <param name="id">employee id</param>
        /// <returns>string employee info</returns>
        [HttpGet("{id}")]
        public string Get(int id)
        {
            Employee employee = new Employee();
            Connection connection = new Connection();
            using(connection.OpenConnection())
            {
                string query = "select * from Employee where Id = " + id;
                SqlCommand command = connection.CreateQuery(query);
                SqlDataReader reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                while (reader.Read())
                {
                    employee.EmployeeId = Convert.ToInt32(reader["Id"]);
                    employee.Name = reader["Name"].ToString();
                    employee.Date = Convert.ToDateTime(reader["Date"]);
                }
            }
            return "Employee name is: " + employee.Name +" date is: " + employee.Date.ToString("dd/MM/yyyy");
        }

        // POST api/<EmployeeController>
        /// <summary>
        /// insert values into the database
        /// </summary>
        /// <param name="value">send employee name as parameter</param>
        [HttpPost]
        public void Post([FromBody] string value)
        {
            Employee employee = new Employee();
            employee.Name = value.ToString();
            employee.Date = DateTime.Now;

            Connection connection = new Connection();
            using(connection.OpenConnection())
            {
                string query = "insert into Employee values(@Name, @Date)";

                SqlCommand command = connection.CreateQuery(query);

                command.Parameters.Add("@Name", SqlDbType.NVarChar).Value = employee.Name;
                command.Parameters.Add("@Date", SqlDbType.Date).Value = employee.Date;
                command.ExecuteNonQuery();
            }
        }

        // DELETE api/<EmployeeController>/5
        /// <summary>
        /// deletes from database
        /// </summary>
        /// <param name="id">send employee id as parameter</param>
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            Connection connection = new Connection();
            using(connection.OpenConnection())
            {
                string query = "delete from Employee where Id = " +id;
                SqlCommand command = connection.CreateQuery(query);
                command.ExecuteNonQuery();
            }
        }
    }
}
