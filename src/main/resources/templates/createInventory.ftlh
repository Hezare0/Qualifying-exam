<#import "parts/common.ftlh" as c>
<@c.page>
    <div>
        <form action="/inventory/${department.id}" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">Дата</span>
                <input type="date" required class="form-control" name="date" id="visitingDate">
            </div>
            <div class="form-floating mb-3">
                    <textarea class="form-control" id="departmentHead" style="height: 8vh">${department.departmentHead.lastname} ${department.departmentHead.firstname} ${department.departmentHead.middlename}</textarea>
                <label for="purposeOfTheLesson">Руководитель подразделения</label>
            </div>
            <div class="form-floating mb-3">
                    <textarea class="form-control" id="departmentHead" style="height: 8vh">${department.departmentHead.lastname} ${department.departmentHead.firstname} ${department.departmentHead.middlename}</textarea>
                <label for="purposeOfTheLesson">Сотрудник ХО: ${employee.lastname} ${employee.firstname} ${employee.middlename}</label>
            </div>

            <#list furnitureList as furniture>
                <div class="input-group-sm mb-3">
                    <label>Инвентарный номер: ${furniture.id}</label>
                    <label>Дата закрепления за подразделением: ${furniture.dateAssignedDepartment}</label>
                    <label>Материально ответственное лицо: ${furniture.financiallyResponsiblePerson.lastname} ${furniture.financiallyResponsiblePerson.firstname} ${furniture.financiallyResponsiblePerson.middlename}</label>
                    <input type="hidden" value="${furniture.id}" name="furnitureIds">
                    <select class="form-select" required id="degreeOfWear" name="wearIds">
                        <option value="" selected disabled hidden>Степень износа</option>
                        <#list degreeOfWearList as degree>
                            <option value="${degree.id!"No value"}">${degree.wearShortName!"No value"}</option>
                        </#list>
                    </select>
                </div>
            </#list>

            <div class="mb-3">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button class="btn btn-outline-primary btn-lg mb-6" type="submit">Сохранить</button>
            </div>
        </form>
    </div>
</@c.page>