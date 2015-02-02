<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0"
                xmlns:ns="src/java/Xml/pr.xml">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Profile</h2>
                <xsl:element name="ns:profile">        
                    <xsl:element name = "ns:name">
                        
                        <p>
                           Name: <xsl:value-of select = "/profile/person/name"/>
                        </p>
                    </xsl:element>
                    <xsl:element name = "ns:surName">
                        <p>
                        SurName: <xsl:value-of select = "/profile/person/surName"/>
                        </p>
                    </xsl:element>
                       <xsl:element name = "ns:gender">
                        <p>
                        Gender:   <xsl:value-of select = "/profile/person/gender"/>
                        </p>
                    </xsl:element>
                    <xsl:element name = "ns:ssn">
                        <p>
                        SSN:   <xsl:value-of select = "/profile/person/ssn"/>
                        </p>
                    </xsl:element>                
                </xsl:element>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>UniversityName</th>
                        <th>Degree</th>
                        <th>GPA</th>
                    </tr>
                    <xsl:for-each select="profile/person/university">
                        <xsl:sort select="universityName"/>
                          <tr>
                            <td><xsl:value-of select="universityName"/></td>
                            <td><xsl:value-of select="degree"/></td>
                            <td><xsl:value-of select="sum(//point) div count(//point)"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
                <br/>
                <h2>Experience</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>CompanyName</th>
                        <th>Industry</th>
                        <th>StartDate</th>
                        <th>EndDate</th>
                    </tr>
                    <xsl:for-each select="profile/person/experience/companyInfo">
                        <xsl:sort select="companyName"/>
                        <tr>
                            <td><xsl:value-of select="companyName"/></td>
                            <td><xsl:value-of select="industry"/></td>
                            <td><xsl:value-of select="startDate"/></td>
                             <td><xsl:value-of select="endDate"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
                
            </body>
        </html>         
    </xsl:template>
</xsl:stylesheet>