package com.example.xmlparsingrssfeedhttpurlconnections

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
class Channel {

    @field:ElementList(inline = true, name = "item")
    var items: List<Item>? = null
//    @field:Element(name = "title")
//    var title: String? = null

}
