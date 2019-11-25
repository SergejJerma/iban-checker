<#import "parts/common.ftl" as c>

<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="post" action="/list" class="form-control">
         <div class="form-group">
         <label for="path">Filepath: (e.g. C:/myFolder/)</label>
            <input type="text" name="filePath" id="path" class="form-control" placeholder="Enter the path to the file" required />
         </div>
         <div class="form-group">
         <label for="name">Filename:</label>
            <input type="text" name="fileName" id="name" class="form-control" placeholder="Enter a filename" required />
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-primary ml-2">Check</button>
           </div>
           
            
            <#if messageValid??>
                     <div class="valid-feedback">
                        ${messageValid}
                    </div>
            </#if>
        </form>
    </div>
</div>
</@c.page>