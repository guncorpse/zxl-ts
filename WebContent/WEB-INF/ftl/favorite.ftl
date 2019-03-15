<#include "./commons/head.ftl">
<body>
  <!-- Sidenav -->
  
  <!-- Main content -->
  <div class="main-content">
    <#include "./commons/top-nav.ftl">
    <div class="header bg-gradient-primary pb-8 pt-5 pt-md-8">
  	  <div class="container-fluid">
        <div class="header-body">
        </div>
      </div>
    </div>
    <!-- Page content -->
    <div class="container-fluid mt--7">
      <div class="row">
        <div class="col-xl-12 mb-12 mb-xl-0">
          <div class="card shadow">
            <div class="card-header bg-transparent">
              <div class="row align-items-center">
                <div class="col">
                  <h6 class="text-uppercase ls-1 mb-1">你自己收藏的喜欢书籍</h6>
                  <#if userInfo??><h2 class="mb-0">${userInfo.name}的收藏夹</h2></#if>
                </div>
              </div>
            </div>
            <div class="card-body">
            
           	  <div class="row">
           	  	
           	  	<#if favorites?size lt 1>
           	  		<div class="col-xl-6 offset-3">
	           	  		<div class="alert alert-warning" role="alert" style="100%">
						    <strong>你还没有收藏书籍，</strong> 快去搜索收藏吧。
						</div>
           	  		</div>
           	  	<#else>
	           	  	<#list favorites as book>
		           	    <div class="col-xl-2 mb-3">
			              <div class="card shadow" style="width: 100%;">
						    <a href="${book.bookAlt}" target="_blank"><img class="card-img-top" src="${book.bookImage}" alt="Card image cap"></a>
							<div class="card-body">
							  <a href="${book.bookAlt}" target="_blank"><h5 class="card-title" style="text-overflow:ellipsis;overflow:hidden;white-space:nowrap">${book.bookTitle}</h5></a>
							  <p class="card-text" style="font-size:12px;text-overflow:ellipsis;overflow:hidden;white-space:nowrap">${book.bookAuthor}</p>
							</div>
							<button data-toggle="modal" data-target="#deleteModal" data-delete-url="${assets_path}/favorite/delete.htm?id=${book.id}" class="btn btn-warning btn-sm btn-block" style="border-radius:0px">删除此收藏</button>
						  </div>
			            </div>
		            </#list>
		         </#if>
           	  </div>
            </div>
          </div>
        </div>
      </div>
	  <#include "./commons/footer.ftl">
    </div>
  </div>
  <#include "./commons/body-script.ftl">
</body>

</html>