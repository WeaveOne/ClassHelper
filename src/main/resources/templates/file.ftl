<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <title>Hello World!</title>
    </head>
    <body>
       <form method="POST" enctype="multipart/form-data" action="/uploadImg"> 
       				
       				<input type="text" name="encryptionParameter" value="id" />
       				<input type="text" name="key" value="0cf395f0ae2a4c332a093cd19944e871" />
           <p>文件：<input type="text" name="id" value="123" /></p>
            <p><input type="file" name="file" /></p>
           <p><input type="submit" value="上传" /></p>
       </form>
    </body>
</html>