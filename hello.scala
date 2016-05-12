// http://www.tutorialspoint.com/scala/scala_quick_guide.htm
import Array._
import java.io._
import scala.util.matching.Regex
import scala.io.Source

trait Equal {
  def isEqual(x: Any): Boolean
  def isNotEqual(x: Any): Boolean = !isEqual(x)
}

class Point (xc: Int, yc: Int) extends Equal {
  var x: Int = xc
  var y: Int = yc
  
  def isEqual(obj: Any) =
    obj.isInstanceOf[Point] &&
    obj.asInstanceOf[Point].x == x
  
  def move(dx: Int, dy: Int){
    x = x + dx
    y = y + dy
    println("Point x location :" + x);
    println("Point y location : " + y);
  }
}

class Location(val xc: Int, val yc: Int, val zc : Int) extends Point(xc, yc){
	var z: Int = zc
	
	def move(dx: Int, dy: Int, dz: Int){
	  x = x + dx
	  y = y + dy
	  z = z + dz
	  println("Point x location : " + x);
	  println("Point y location : " + y);
	  println("Point z location : " + z);
	}
}

object HelloWorld {
	def main(args: Array[String]){
	  // println("Hello, world!")
	  // println("Returned Value : " + addInt(5,7));
	  // println("multiplier(1) value = " + multiplier(1))
	  //println("multiplier(2) value = " + multiplier(2))
	  var palindrome = "Dot saw I was Tod";
	  var len = palindrome.length();
	  println("String Length is : " + len);
	  
	  var z:Array[String] = new Array[String](3)
	  
	  var myMatrix = ofDim[Int](3,3)
	  
	  // build a matrix
	  for (i <- 0 to 2){
	    for ( j <- 0 to 2){
	      myMatrix(i)(j) = j;
	    }
	  }
	  
	  // Print two dimensional array
	  for(i <- 0 to 2){
	    for( j <- 0 to 2){
	      print(" " + myMatrix(i)(j));
	    }
	    println();
	  }
	  
	  println(matchTest(1))
	  println(matchTest(3))
	  println(matchTest("two"))
	  println(matchTest("test"))
	  
	  val alice = new Person("Alice", 25)
	  val bob = new Person("Bob", 32)
	  val charlie = new Person("Charlie", 18)
	  
	  for(person <- List(alice, bob, charlie)){
	    person match {
	      case Person("Alice", 25) => println("Hi Alice!")
	      case Person("Bob", 32) => println("Hi Bitch Tits!")
	      case Person(name, age) => println("Age: " + age + " year, name: " + name + "?")
	      
	    }
	  }
	  
	  val pattern = "Scala".r
	  var str = "Scala is Scalable and cool"
	  println(pattern findFirstIn str)    
	  // Some(Scala)
	  
	  val pattern2 = new Regex("(S|s)cala")
	  println((pattern2 findAllIn str).mkString(","))
	  // Scala,scala
	  
	  val pattern3 = new Regex("abl[ae]\\d+")
	  val str3 = "ablaw is able1 and cool"
	  println((pattern3 findAllIn str3).mkString(","))
	  // able1
	  
	  try {
	    val f = new FileReader("input.txt")
	  } catch {
	    case ex: FileNotFoundException => {
	    	println("Missing file exception")
	    }
	    case ex: IOException => {
	    	println("IO Exception")
	    }
	  } finally {
	    println("Exiting finally ...")
	  }
	  
	  println("Apply method: " + apply("Zara", "gmail.com"));
	  println("Unapply method: " + unapply("Zara@gmail.com"));
	  println("Unapply method: " + unapply("Zara Ali"));
	  
	  // http://www.tutorialspoint.com/scala/scala_file_io.htm
	  val writer = new PrintWriter(new File("test.txt"))
	  writer.write("Hello Scala")
	  writer.close()
	  
//	   val line = Console.readLine;
//	   println("Thanks, you just typed: " + line)
	  
	  Source.fromFile("test.txt").foreach {
	    print
	  }
	}
	
	var factor = 3
	val multiplier = (i:Int) => i * factor
	def addInt( a:Int, b:Int ) : Int = {
	  var sum:Int = 0
	  sum = a + b
	  return sum
	}
	
	val x = List(1,2,3,4)
	
	val pt = new Point(10, 20);
	val p2 = new Point( 2, 4);
	
	// Move to a new location
	pt.move(10, 10)
	
	val loc = new Location(10, 20, 15);
	
	// Move to a new location
	loc.move(10, 10, 5);

	println("[")
	println(pt.isEqual(p2))
	println(pt.isNotEqual(p2))
	println("]")
	
	def matchTest(x: Any) : Any = x match {
	  case 1 => "one"
	  case "two" => 2
	  case y: Int => "scala.Int"
	  case _ => "many"
	}
	
	case class Person(name: String, age: Int)
	
	// The injection method (optional)
	def apply(user: String, domain: String) = {
	  user + "@" + domain
	}
	
	// The extraction method (mandatory)
	def unapply(str: String) : Option[(String, String)] = {
	  val parts = str split "@"
	  if (parts.length == 2) {
	    Some(parts(0), parts(1))
	  } else {
	    None
	  }
	}
}

object add {
  def addInt( a:Int, b:Int ) : Int = {
    var sum:Int = 0
    sum = a + b
    return sum
  }
}

object Hello{
  def printMe() : Unit = {
    println("Hello, Scala!")
  }
}