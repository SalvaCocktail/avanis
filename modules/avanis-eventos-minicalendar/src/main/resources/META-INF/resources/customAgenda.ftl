<#-- custom_agenda_template.ftl -->
<div class="my-custom-agenda">
    <#list events as event>
        <div class="my-custom-event" style="background-color: ${event.backgroundColor}; color: ${event.color};">
            <h3>${event.title}</h3>
            <p>${event.description}</p>
        </div>
    </#list>
</div>