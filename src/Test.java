import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES
        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join

       REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them

        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."

        Store all these 3 objects in a collection and print them

        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int countMath = 0;
        int countScience = 0;
        do {
            System.out.println(UserQuestions.askToJoin);
            String toJoin = input.nextLine();

            if (toJoin.toLowerCase().startsWith("y")) {

                System.out.println(UserQuestions.askFirstName);
                String firstName = input.nextLine();
                System.out.println(UserQuestions.askLastName);
                String lastName = input.nextLine();

                System.out.println(UserQuestions.askAge);
                int age = input.nextInt();
                input.nextLine();
                try {
                    Permission.checkAge(age);
                }catch(Exception e){
                    e.printStackTrace();
                    continue;
                }
                System.out.println(UserQuestions.askGender);
                String gender = input.nextLine();

                System.out.println(UserQuestions.askClassName);
                String className = input.nextLine();
                try{
                    Permission.checkClassName(className);
                }catch(Exception e){
                    e.printStackTrace();
                    break;
                }
                if(className.equalsIgnoreCase("Math")){
                   countMath++;
                   System.out.println("Congratulations! You are registered for " + className + " class.");
                   students.add(new MathStudent(firstName, lastName, age, gender, className ));
               }else if(className.equalsIgnoreCase("Science")){
                   countScience++;
                   System.out.println("Congratulations! You are registered for " + className + " class.");
                   students.add(new ScienceStudent(firstName, lastName, age, gender, className));
               }
            }
        } while ((countMath + countScience) < 3);

            for (Student student : students) {
                System.out.println(student);
            }
            if(students.size() == 3){
                System.out.println("Math students = " + countMath);
                System.out.println("Science students = " + countScience);
            }
        }
     }

