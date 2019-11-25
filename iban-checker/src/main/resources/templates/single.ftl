<#import "parts/common.ftl" as c>

<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="post" action="/single" class="form-inline">
            <input type="text" name="ibanToCheck" class="form-control" placeholder="Enter a IBAN number" required />
            <button type="submit" class="btn btn-primary ml-2">Check</button>
                  
        </form>
    </div>
</div>
   
   <div>
       ${message?ifExists}
    </div>
</div>
</@c.page>