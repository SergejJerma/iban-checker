<#import "parts/common.ftl" as c>

<@c.page>
	<h5>Checking results:</h5>
   <div>
  	${iban?ifExists} ${message?ifExists}
    </div>
</@c.page>