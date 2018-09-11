using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace simple_calc
{
    class Program
    {
        static void Main(string[] args)
        {
            char again = 'y';
            while (again == 'y')
            {
                double a;
                double b;
                char oper;

                Console.WriteLine("First number:");
                a = Convert.ToDouble(Console.ReadLine());

                Console.WriteLine("Operator:");
                oper = Convert.ToChar(Console.ReadLine());

                Console.WriteLine("Second number:");
                b = Convert.ToDouble(Console.ReadLine());

                var operations = new Dictionary<char, Func<double, double, double>>
                    {
                        {'x', (x, y) => x * y },
                        {'/', (x, y) => x / y },
                        {'+', (x, y) => x + y },
                        {'-', (x, y) => x - y }
                    };
                if(operations.Keys.Contains(oper)) {
                    Console.WriteLine("Result " + operations[oper](a, b));
                } else {
                    Console.WriteLine("Unknown operator");
                }

                Console.WriteLine("Do you want to continue? (y/n)");
                again = Convert.ToChar(Console.ReadLine());
            }
        }
    }
}
