package Lab1


enum class Grade(val value: Int) {
    A(5),
    B(4),
    C(3),
    NOT_FINISHED(0)
}

data class Course(
    val title: String,
    val grade: Grade,
)

data class Student(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val emails: List<String>,
    val phones: List<String>,
    val courses: List<Course>
)

fun main() {
    println("Hello World!")
    println("hi!")
    val adresses = "1.754291, Санкт-Петербург, ул. Космонавтов, д.47\n" +
            "2.563084, Москва, ул. Ленина, д.13\n" +
            "3.687424, Киров, ул. Энгельса, д.64\n" +
            "4.194192, Анапа, ул. Типанова, д.27\n" +
            "5.532212, Ставрополь, ул. Киевская,\tд.64\n" +
            "6.128925, Уфа, ул. Херсонская, д.63\n" +
            "7.576277, Москва, ул. Громова, д.88\n" +
            "8.100785, Минск, ул. Дивенская, д.88\n" +
            "9.304883, Мурманск, ул. Съезжинская, д.86\n" +
            "10.976672, Птерозаводск, ул. Труда, д.84\n" +
            "11.773348, Санкт-Петеребург, ул. Глинка, д.19\n" +
            "12.728544, Белгород, ул. Шкапина, д.51\n" +
            "13.176478, Калининград, ул. Звездная, д.84\n" +
            "14.440636, Москва, ул. Ленина, д.73\n" +
            "15.383197, Москва, ул. Алтайская, д.2\n" +
            "16.706150, Санкт-Петербург, ул. Громова, д.16\n" +
            "17.637562, Минск, ул. Космонавтов, д.64\n" +
            "18.795466, Уфа, ул. Типанова, д.37\n" +
            "19.169130, Владивосток, ул. Шевцова, д.29\n" +
            "20.240555, Киров, ул. Кировская, д.53".trimIndent()
    val adresses2 = """1.754291, Санкт-Петербург, ул. Космонавтов, д.47
2.563084, Москва, ул. Ленина, д.13
3.687424, Киров, ул. Энгельса, д.64
4.194192, Анапа, ул. Типанова, д.27
5.532212, Ставрополь, ул. Киевская,	д.64
6.128925, Уфа, ул. Херсонская, д.63
7.576277, Москва, ул. Громова, д.88
8.100785, Минск, ул. Дивенская, д.88
9.304883, Мурманск, ул. Съезжинская, д.86
10.976672, Птерозаводск, ул. Труда, д.84
11.773348, Санкт-Петеребург, ул. Глинка, д.19
12.728544, Белгород, ул. Шкапина, д.51
13.176478, Калининград, ул. Звездная, д.84
14.440636, Москва, ул. Ленина, д.73
15.383197, Москва, ул. Алтайская, д.2
16.706150, Санкт-Петербург, ул. Громова, д.16
17.637562, Минск, ул. Космонавтов, д.64
18.795466, Уфа, ул. Типанова, д.37
19.169130, Владивосток, ул. Шевцова, д.29
20.240555, Киров, ул. Кировская, д.53""".trimIndent()


    println(adresses.length)
    val students = loadStudents()
    val ivans = students.filter { it.firstName == "Ivan" }
    val adultNotIvans = students.filter { it.firstName != "Ivan" && it.age >= 18 }

    val studentWithContacts = students.filter { it.emails.isNotEmpty() || it.phones.isNotEmpty() }
    val fullNames = students.map { "${it.firstName} ${it.lastName} - ${it.age}" }

    val studentAndTheirAvgGrade = students.map { student ->
        val avg = student.courses
            .filter { course -> course.grade != Grade.NOT_FINISHED }
            .map { course -> course.grade.value }
            .average()
        student to avg
    }


    val splitString = adresses.split('\n')
    for (str in splitString) {
        val curStr=str.split(',')
        val index=curStr[3].substring(curStr[3].indexOf(", ")+4)
        println("index is:$index")
    }

}


fun loadStudents(): List<Student> {
    return emptyList()
}
