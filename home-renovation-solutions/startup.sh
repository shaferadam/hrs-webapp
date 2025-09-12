#!/bin/bash
echo "📦 Copying ROOT.war to Tomcat webapps..."
cp /home/site/wwwroot/ROOT.war /usr/local/tomcat/webapps/ROOT.war

echo "📂 Listing contents of /usr/local/tomcat/webapps:"
ls -l /usr/local/tomcat/webapps/

echo "✅ Startup script completed."