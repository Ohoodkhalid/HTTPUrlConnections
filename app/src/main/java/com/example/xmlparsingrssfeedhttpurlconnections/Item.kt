package com.example.xmlparsingrssfeedhttpurlconnections

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "item", strict = false)
class Item @JvmOverloads constructor
    (
    @field:Element(name = "title")
    var title: String? = null,

    @field:Element(name = "enclosure")
var enclosure: Url? = null




)
