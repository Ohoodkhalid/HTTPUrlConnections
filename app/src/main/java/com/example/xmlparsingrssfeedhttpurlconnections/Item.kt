package com.example.xmlparsingrssfeedhttpurlconnections

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item ", strict = false)

class Item @JvmOverloads constructor
    (

@field:Element(name = "content:encoded")
var content : ArrayList<String> ? = null



)
