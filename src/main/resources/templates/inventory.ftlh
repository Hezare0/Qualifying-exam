<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 g-4">
        <#list departments as department>
            <div class="col">
                <div class="card text-center my-3 h-100">
                    <div class="card-body">
                        <h5 class="card-title">
                            Департамент: ${department.departamentName}
                        </h5>
                        <p class="card-text">
                            Компания: ${department.company.companyShortName}
                        </p>
                        <p class="card-text">
                            Глава департамента:
                            <#if department.departmentHead.lastname??>
                                ${department.departmentHead.lastname}
                            </#if>
                            <#if department.departmentHead.firstname??>
                                ${department.departmentHead.firstname}
                            </#if>
                            <#if department.departmentHead.middlename??>
                                ${department.departmentHead.middlename}
                            </#if>
                        </p>
                    </div>
                    <div class="card-footer text-muted">
                        <form action="/inventory/${department.id}" method="get">
                            <button class="btn btn-outline-primary" type="submit">Начать инвентаризацию</button>
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                        </form>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</@c.page>
