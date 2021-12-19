package com.example.xmlparsingrssfeedhttpurlconnections

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList

class Channel {

    //    @field:ElementList(inline = true, name = "item")
//    var items: List<Item>? = null
    @field:Element(name = "title")
    var title: String? = null

}
