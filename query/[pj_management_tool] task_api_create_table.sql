drop table if exists tool_comments;
drop table if exists tool_task_tag;
drop table if exists tool_tasks;
drop table if exists tool_tags;
drop table if exists tool_milestones;
drop table if exists tool_project_participants;
drop table if exists tool_projects;

create table tool_projects(
	project_no int not null auto_increment,
    project_state varchar(20) not null,
    project_name varchar(30) not null,
    project_explanation varchar(300) null,
    primary key (project_no)
);

create table tool_project_participants(
	participant_account_id varchar(20) not null,
    project_no int not null,
    participant_authority varchar(20) not null,
    primary key (participant_account_id, project_no),
    foreign key (project_no) references tool_projects (project_no)
);

create table tool_milestones(
	milestone_no int not null auto_increment,
    milestone_name varchar(30) not null,
    milestone_state varchar(20) not null,
    milestone_start_date date null,
    milestone_finish_date date null,
    project_no int not null,
    primary key (milestone_no),
    foreign key (project_no) references tool_projects (project_no)
);

create table tool_tags(
	tag_no int not null auto_increment,
    tag_name varchar(20) not null,
	project_no int not null,
    primary key (tag_no),
    foreign key (project_no) references tool_projects (project_no)
);

create table tool_tasks(
	task_no int not null auto_increment,
    task_create_datetime datetime not null,
    task_title varchar(100) not null,
    task_content varchar(1000) null,
    participant_account_id varchar(20) not null,
    project_no int not null,
    milestone_no int null,
    primary key (task_no),
    foreign key (participant_account_id, project_no) references tool_project_participants (participant_account_id, project_no),
    foreign key (milestone_no) references tool_milestones (milestone_no)
);

create table tool_task_tag(
	task_no int not null,
    tag_no int not null,
    primary key (task_no, tag_no),
    foreign key (task_no) references tool_tasks (task_no),
    foreign key (tag_no) references tool_tags (tag_no)
);

create table tool_comments(
	comment_no int not null auto_increment,
    comment_writer_account_id varchar(20) not null,
    comment_content varchar(200) not null,
    comment_write_datetime datetime not null,
    comment_modify_datetime datetime null,
    task_no int not null,
    primary key (comment_no),
    foreign key (task_no) references tool_tasks (task_no)
);

show tables;
