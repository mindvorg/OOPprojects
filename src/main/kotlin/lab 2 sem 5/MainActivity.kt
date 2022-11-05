/*
package `lab 2 sem 5`

class MainActivity {
    var empDataHashMap = hashMapOf()
    var empList: ArrayList<HashMap> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            val lv = findViewById(R.id.listView)
            val istream = assets.open("empdetail.xml")
            val builderFactory = DocumentBuilderFactory.newInstance()
            val docBuilder = builderFactory.newDocumentBuilder()
            val doc = docBuilder.parse(istream)
            //reading the tag "employee" of empdetail file
            val nList = doc.getElementsByTagName("employee")
            for(i in 0 until nList.getLength()) {
                if(nList.item(0).getNodeType().equals(Node.ELEMENT_NODE) ) {
                    //creating instance of HashMap to put the data of node value
                    empDataHashMap = HashMap()
                    val element = nList.item(i) as Element
                    empDataHashMap.put("name", getNodeValue("name", element))
                    empDataHashMap.put("salary", getNodeValue("salary", element))
                    empDataHashMap.put("designation", getNodeValue("designation", element))
                    //adding the HashMap data to ArrayList
                    empList.add(empDataHashMap)
                }
            }
            val adapter = SimpleAdapter(this@MainActivity, empList, R.layout.custom_list, arrayOf("name", "salary", "designation"), intArrayOf(R.id.name, R.id.salary, R.id.designation))
            lv.setAdapter(adapter)
        } catch(e: IOException) {
            e.printStackTrace()
        } catch(e: ParserConfigurationException) {
            e.printStackTrace()
        } catch(e: SAXException) {
            e.printStackTrace()
        }

        Источник: https://java-blog.ru/kotlin/3-sposoba-analiza-i-chteniya-xml-faylov-s-kotlin-android*/
