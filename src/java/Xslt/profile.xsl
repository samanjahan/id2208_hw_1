<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0"
                xmlns:ns="src/java/Xml/pr.xml">
    <xsl:template match="/">
        <xsl:element name="ns:profile">        
            <xsl:element name = "ns:name">
                <xsl:value-of select = "/profile/person/name"/>
            </xsl:element>
            <xsl:element name = "ns:surName">
                <xsl:value-of select = "/profile/person/surName"/>
            </xsl:element>
            <xsl:element name = "ns:ssn">
                <xsl:value-of select = "/profile/person/ssn"/>
            </xsl:element>                
         </xsl:element>     
    </xsl:template>
</xsl:stylesheet>