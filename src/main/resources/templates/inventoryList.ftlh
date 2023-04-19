<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 g-4">
        <#list inventoryList as inventory>
            <div class="col">
                <div class="card text-center my-3 h-100">
                    <div class="card-body">
                        <h5 class="card-title">
                            Дата: ${inventory.date}
                        </h5>
                        <p class="card-text">
                            Департамент: ${inventory.department.departamentName}
                        </p>
                        <p class="card-text">
                            Проверяющий:
                            <#if inventory.businessDepartmentEmployees.lastname??>
                                ${inventory.businessDepartmentEmployees.lastname}
                            </#if>
                            <#if inventory.businessDepartmentEmployees.firstname??>
                                ${inventory.businessDepartmentEmployees.firstname}
                            </#if>
                            <#if inventory.businessDepartmentEmployees.middlename??>
                                ${inventory.businessDepartmentEmployees.middlename}
                            </#if>
                        </p>
                    </div>
                    <div class="card-footer text-muted">
                        <form action="/inventory-list/excel/${inventory.id}" method="get">
                            <button class="btn btn-outline-primary" type="submit">Скачать</button>
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                        </form>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</@c.page>
