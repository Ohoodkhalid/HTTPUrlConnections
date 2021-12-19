package com.example.xmlparsingrssfeedhttpurlconnections

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root
import java.io.Serializable


@Root(name = "enclosure", strict = false)

class Url  @JvmOverloads constructor
    (@field:Attribute(name = "url",required = false)
     var url: String? = null):Serializable {




}