<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
  	<#if pagen lt 2>
    <li class="page-item disabled">
    <#else>
    <li class="page-item">
    </#if>
      <#if pageName == 'search'>
      <a class="page-link" href="${assets_path}/search.htm?keyword=${keyword}&pagen=${pagen - 1}">
      </#if>
      <#if pageName == 'index'>
      <a class="page-link" href="${assets_path}/index.htm?pagen=${pagen - 1}">
      </#if>
        <i class="fa fa-angle-left"></i>
        <span class="sr-only">Previous</span>
      </a>
    </li>
    <li class="page-item active"><a class="page-link" href="#">${pagen}</a></li>
    <#if pagen gt total/count>
    <li class="page-item disabled">
    <#else>
    <li class="page-item">
    </#if>
      <#if pageName == 'search'>
      <a class="page-link" href="${assets_path}/search.htm?keyword=${keyword}&pagen=${pagen + 1}">
      </#if>
      <#if pageName == 'index'>
      <a class="page-link" href="${assets_path}/index.htm?pagen=${pagen + 1}">
      </#if>
        <i class="fa fa-angle-right"></i>
        <span class="sr-only">Next</span>
      </a>
    </li>
    <li style="margin-left:20px;line-height:36px;">共${total}条数据，${total/count}页</li>
  </ul>
</nav>