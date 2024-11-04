<%@ tag description="Reusable head content" pageEncoding="UTF-8" %>
<%@ attribute name="project" required="true" type="info.preva1l.slave.master.models.projects.Project" %>

<div class="project w-64 min-h-[24rem] hover:shadow-xl c-shadow-transition flex flex-col items-center space-y-3">
    <img src="${pageContext.request.contextPath}/content/logos/${project.shortId}.png" alt="Project Logo" class="max-h-[16rem]">
    <h4 id="project-name" class="text-2xl font-bold self-center text-center">${project.name}</h4>
    <div id="btn-container" class="w-full flex items-center justify-center">
        <a id="info-btn" class="project-btn bg-[#336699] hover:bg-white transition-colors duration-300 px-6 py-2 text-white hover:text-black">Info</a>
        <a id="docs-btn" class="project-btn bg-[#336699] hover:bg-white transition-colors duration-300 px-6 py-2 text-white hover:text-black">Docs</a>
    </div>
</div>